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

/*
@Tag(name= "BitBucket", description="BitBucket management API")

 */

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
    /*
    @Operation(summary="Retrieve a project by workspace and repo slug",
            description="Get a project object by specifying its workspace and repo slug",
            tags={"projects", "get"})
     @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Project retrieved",
            content = { @Content(schema = @Schema(implementation = ProjectDB.class),
            mediaType = "application/json") }),
     @ApiResponse(responseCode = "404", description = "Project not found", content = { @Content(schema = @Schema()) })
     */
    @GetMapping("/{workspace}/{repo_slug}")
    public ProjectDB getProject(@PathVariable String workspace, @PathVariable String repo_slug,
                                @RequestParam(defaultValue = "5")String nCommits, @RequestParam(defaultValue = "5")String nIssues,
                                @RequestParam(defaultValue = "2")String maxPages){
        ProjectValue project = projectService.getProjectByName(workspace, repo_slug);
        List<CommitValue> commits = commitService.getCommitsMaxPages(workspace, repo_slug, nCommits, maxPages);
        List<IssueValue> issues = issueService.getIssuesMaxPages(workspace, repo_slug, nIssues, maxPages);
        ProjectDB projectDB = transform.transform(project, commits, issues, maxPages);
        return projectDB;
    }

    /*
    @Operation(summary="Post a project to GitMiner by workspace and repo slug",
            description="Get a project object by specifying its workspace and repo slug, and it's sent to GitMiner",
            tags={"projects", "post"})
     @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Project posted",
            content = { @Content(schema = @Schema(implementation = ProjectDB.class),
            mediaType = "application/json") }),
     @ApiResponse(responseCode = "404", description = "Project not found", content = { @Content(schema = @Schema()) })
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{workspace}/{repo_slug}")
    public ProjectDB createProject(@PathVariable String workspace, @PathVariable String repo_slug,
                                @RequestParam(defaultValue = "5")String nCommits, @RequestParam(defaultValue = "5")String nIssues,
                                @RequestParam(defaultValue = "2")String maxPages){
        ProjectValue project = projectService.getProjectByName(workspace, repo_slug);
        List<CommitValue> commits = commitService.getCommitsMaxPages(workspace, repo_slug, nCommits, maxPages);
        List<IssueValue> issues = issueService.getIssuesMaxPages(workspace, repo_slug, nIssues, maxPages);
        ProjectDB projectDB = transform.transform(project, commits, issues, maxPages);
        String uri = "http://localhost:8080/gitminer/projects";
        HttpEntity<ProjectDB> request = new HttpEntity<>(projectDB);
        ResponseEntity<ProjectDB> response = restTemplate.exchange(uri, HttpMethod.POST, request, ProjectDB.class);
        return response.getBody();
    }
}
