package aiss.bitbucketminer.controller;

import aiss.bitbucketminer.model.CommentValue;
import aiss.bitbucketminer.model.CommitValue;
import aiss.bitbucketminer.model.IssueValue;
import aiss.bitbucketminer.model.ProjectValue;
import aiss.bitbucketminer.service.CommentService;
import aiss.bitbucketminer.service.CommitService;
import aiss.bitbucketminer.service.IssueService;
import aiss.bitbucketminer.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bitbucket")
public class CommentController {

    //http://localhost:8081/bitbucket/gentlero/bitbucket-api?nCommits=5&nIssues=5&maxPages=2

    private CommentService commentService;
    private ProjectService projectService;
    private CommitService commitService;
    private IssueService issueService;

    @Autowired
    public CommentController(CommentService commentService, ProjectService projectService, CommitService commitService, IssueService issueService) {
        this.commentService = commentService;
        this.projectService = projectService;
        this.commitService = commitService;
        this.issueService = issueService;
    }

    // @Value("${bitbucketminer.baseUri}")
    // private String baseUri;

    //apipath/{workspace}/{repo_slug}[?nCommits=5&nIssues=5&maxPages=2]
    // /issues/{issueId}/comments/{id}

    //http://localhost:8080/bitbucket/gentlero/bitbucket-api
    @GetMapping("/{workspace}/{repo_slug}")
    public ProjectValue getProjectByName(@PathVariable String workspace, @PathVariable String repo_slug){
        ProjectValue project = projectService.getProjectByName(workspace, repo_slug);
        return project;
    }

    //http://localhost:8080/bitbucket/gentlero/bitbucket-api
    @GetMapping("/{workspace}/{repo_slug}/commits")
    public List<CommitValue> getCommitProject(@PathVariable String workspace, @PathVariable String repo_slug){
        List<CommitValue> commits = commitService.getCommits(workspace, repo_slug);
        return commits;
    }

    //http://localhost:8080/bitbucket/gentlero/bitbucket-api
    @GetMapping("/{workspace}/{repo_slug}/issues")
    public List<IssueValue> getIssueProject(@PathVariable String workspace, @PathVariable String repo_slug){
        List<IssueValue> issues = issueService.getIssues(workspace, repo_slug);
        return issues;
    }

    //http://localhost:8080/bitbucket/gentlero/bitbucket-api
    @GetMapping("/{workspace}/{repo_slug}/issues/{issue_id}/comments")
    public List<CommentValue> getCommentIssueProject(@PathVariable String workspace, @PathVariable String repo_slug, @PathVariable String issue_id){
        List<CommentValue> comments = commentService.getComments(workspace, repo_slug, issue_id);
        return comments;
    }

    /*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Commit create(Commit newCommit){
        return commitRespository.create(newCommit);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProject(@RequestBody @Valid Commit updatedCommit, @PathVariable String id){
        commitRespository.update(updatedCommit,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletedProject(@PathVariable String id){
        commitRespository.delete(id);
    }

     */
}
