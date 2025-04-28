package aiss.bitbucketminer.controller;

import aiss.bitbucketminer.etl.ProjectDB;
import aiss.bitbucketminer.etl.Transform;
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

    private CommentService commentService;
    private ProjectService projectService;
    private CommitService commitService;
    private IssueService issueService;
    private Transform transform;

    @Autowired
    public CommentController(CommentService commentService, ProjectService projectService, CommitService commitService, IssueService issueService, Transform transform) {
        this.commentService = commentService;
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
                                @RequestParam(defaultValue = "5")String maxPages){
        ProjectValue project = projectService.getProjectByName(workspace, repo_slug);
        List<CommitValue> commits = commitService.getCommits(workspace, repo_slug, nCommits);
        List<IssueValue> issues = issueService.getIssues(workspace, repo_slug, nIssues);
        ProjectDB projectDB = transform.transform(project,commits,issues);
        return projectDB;
    }

    /*

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

    //http://localhost:8080/bitbucket/gentlero/bitbucket-api
    @GetMapping("/{workspace}/{repo_slug}/commits/{commits_id}")
    public CommitValue getCommitProjectById(@PathVariable String workspace, @PathVariable String repo_slug, @PathVariable String commits_id){
        CommitValue commits = commitService.getCommitId(workspace, repo_slug, commits_id);
        return commits;
    }

    //http://localhost:8080/bitbucket/gentlero/bitbucket-api
    @GetMapping("/{workspace}/{repo_slug}/issues/{issue_number}")
    public IssueValue getIssueProjectById(@PathVariable String workspace, @PathVariable String repo_slug, @PathVariable String issue_number){
        IssueValue issues = issueService.getIssueByNumber(workspace, repo_slug, issue_number);
        return issues;
    }

    //http://localhost:8080/bitbucket/gentlero/bitbucket-api
    @GetMapping("/{workspace}/{repo_slug}/issues/{issue_id}/comments/{comments_id}")
    public CommentValue getCommentIssueProjectById(@PathVariable String workspace, @PathVariable String repo_slug, @PathVariable String issue_id, @PathVariable String comments_id){
        CommentValue comments = commentService.getCommentById(workspace, repo_slug, issue_id, comments_id);
        return comments;
    }
     */
}
