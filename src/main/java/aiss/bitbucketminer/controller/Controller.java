package aiss.bitbucketminer.controller;

import aiss.bitbucketminer.etl.ProjectDB;
import aiss.bitbucketminer.etl.Transform;
import aiss.bitbucketminer.model.CommitValue;
import aiss.bitbucketminer.model.IssueValue;
import aiss.bitbucketminer.model.ProjectValue;
import aiss.bitbucketminer.service.CommitService;
import aiss.bitbucketminer.service.IssueService;
import aiss.bitbucketminer.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/bitbucket")
public class Controller {

    private RestTemplate restTemplate;
    private ProjectService projectService;
    private CommitService commitService;
    private IssueService issueService;
    private Transform transform;

    @Autowired
    public Controller(ProjectService projectService, CommitService commitService, IssueService issueService, Transform transform, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.projectService = projectService;
        this.commitService = commitService;
        this.issueService = issueService;
        this.transform = transform;
    }

    //http://localhost:8081/bitbucket/gentlero/bitbucket-api?nCommits=5&nIssues=5&maxPages=2
    //apipath/{workspace}/{repo_slug}[?nCommits=5&nIssues=5&maxPages=2]
    @GetMapping("/{workspace}/{repo_slug}")
    public ProjectDB getProject(@PathVariable String workspace, @PathVariable String repo_slug,
                                @RequestParam(defaultValue = "5")String nCommits, @RequestParam(defaultValue = "5")String nIssues,
                                @RequestParam(defaultValue = "2")String maxPages){
        ProjectValue project = projectService.getProjectByName(workspace, repo_slug);
        List<CommitValue> commits = commitService.getCommits(workspace, repo_slug, nCommits);
        List<IssueValue> issues = issueService.getIssues(workspace, repo_slug, nIssues);
        ProjectDB projectDB = transform.transform(project,commits,issues);
        return projectDB;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{workspace}/{repo_slug}")
    public ProjectDB createProject(@PathVariable String workspace, @PathVariable String repo_slug,
                                @RequestParam(defaultValue = "5")String nCommits, @RequestParam(defaultValue = "5")String nIssues,
                                @RequestParam(defaultValue = "2")String maxPages){
        ProjectValue project = projectService.getProjectByName(workspace, repo_slug);
        List<CommitValue> commits = commitService.getCommits(workspace, repo_slug, nCommits);
        List<IssueValue> issues = issueService.getIssues(workspace, repo_slug, nIssues);
        ProjectDB projectDB = transform.transform(project,commits,issues);
        String uri = "http://localhost:8080/gitminer/projects";
        HttpEntity<ProjectDB> request = new HttpEntity<>(projectDB);
        ResponseEntity<ProjectDB> response = restTemplate.exchange(uri, HttpMethod.POST, request, ProjectDB.class);
        return response.getBody();
    }
}
