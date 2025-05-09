package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.*;
import aiss.bitbucketminer.service.CommentService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Transform {

    private final CommentService commentService;

    public Transform(CommentService commentService) {
        this.commentService = commentService;
    }

    public ProjectDB transform(ProjectValue project, List<CommitValue> commits, List<IssueValue> issues, String maxPages){
        ProjectDB projectDB = transformProject(project);
        transformIssues(issues,projectDB,maxPages);
        transformCommits(commits,projectDB);
        return projectDB;
    }

    public ProjectDB transformProject(ProjectValue project) {
        String projectUuid= project.getUuid();
        Integer length = projectUuid.length();
        String uuid = projectUuid.substring(1, length - 1);
        return new ProjectDB(uuid, project.getName(), project.getLinks().getHtml().getHref());
    }

    public void transformIssues(List<IssueValue> issues, ProjectDB project, String maxPages) {
        for (IssueValue issue: issues) {
            UserDB  reporter = transformUser(issue.getReporter());
            UserDB assignee = null;
            if (issue.getAssignee() != null) {
                assignee = transformUser(issue.getAssignee());
            }
            List<String> labels = new ArrayList<>();
            labels.add(issue.getKind());
            String closedAt = "NOT CLOSED YET";
            if (issue.getState().equals("resolved") || issue.getState().equals("closed")) {
                closedAt = issue.getUpdatedOn();
            }
            String updatedAt = issue.getUpdatedOn();
            if (updatedAt == null) {
                updatedAt = "NOT UPDATED YET";
            }
            IssueDB issueDB = new IssueDB(issue.getId(), issue.getTitle(), issue.getContent().getRaw(), issue.getState(), issue.getCreatedOn(), updatedAt, closedAt, labels, issue.getVotes(), reporter, assignee);
            project.getIssues().add(issueDB);
            List<CommentValue> comments = commentService.getCommentsByUriMaxPages(issue.getLinks().getComments().getHref(), maxPages);
            transformComments(comments, issueDB);
        }
    }

    public void transformCommits(List<CommitValue> commits, ProjectDB project){
        for (CommitValue commit: commits){
            Author author = commit.getAuthor();
            String title = commit.getSummary().getRaw();
            if (title.length() > 255) {
                title = title.substring(0, 255);
            }

            String[] authorNameEmail = author.getRaw().split(" <");
            String name = authorNameEmail[0];
            String email = authorNameEmail[1];
            Integer length = email.length();
            email = email.substring(0, length - 1);

            CommitDB commitDB = new CommitDB(commit.getHash(), title, commit.getMessage(), name,
                    email, commit.getDate(), commit.getLinks().getHtml().getHref());
            project.getCommits().add(commitDB);
        }
    }

    public void transformComments(List<CommentValue> comments, IssueDB issue) {
        for (CommentValue comment: comments) {
            UserDB author = transformUser(comment.getUser());
            String body = comment.getContent().getRaw();
            if (body == null) {
                body = "NO BODY";
            }
            String updatedAt = comment.getUpdatedOn();
            if (updatedAt == null) {
                updatedAt = "NOT UPDATED YET";
            }
            CommentDB commentDB = new CommentDB(comment.getId(), body, comment.getCreatedOn(), updatedAt, author);
            issue.getComments().add(commentDB);
        }
    }

    public UserDB transformUser(User user){
        Integer length = user.getUuid().length();
        String id = user.getUuid().substring(1, length - 1);
        return new UserDB(id, user.getNickname(), user.getDisplayName(), user.getLinks().getAvatar().getHref(), user.getLinks().getHtml().getHref());
    }
}