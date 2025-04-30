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

    public ProjectDB transform(ProjectValue project, List<CommitValue> commits, List<IssueValue> issues){
        ProjectDB projectDB = transformProject(project);
        transformIssues(issues,projectDB);
        transformCommits(commits,projectDB);
        return projectDB;
    }

    public ProjectDB transformProject(ProjectValue project){
        return new ProjectDB(project.getUuid(), project.getName(), project.getLinks().getSelf().getHref());
    }

    public void transformIssues(List<IssueValue> issues, ProjectDB project){
        for (IssueValue issue: issues) {
            UserDB  reporter = transformUser(issue.getReporter());
            UserDB assignee = null;
            if (issue.getAssignee() != null) {
                assignee = transformUser(issue.getAssignee());
            }
            List<String> labels = new ArrayList<>();
            labels.add(issue.getKind());
            IssueDB issueDB = new IssueDB(issue.getId(), issue.getTitle(), issue.getContent().getRaw(), issue.getState(), issue.getCreatedOn(), issue.getUpdatedOn(), null, labels, issue.getVotes(), reporter, assignee);
            project.getIssues().add(issueDB);
            List<CommentValue> comments = commentService.getCommentsByUri(issue.getLinks().getComments().getHref());
            transformComments(comments, issueDB);
        }
    }

    public void transformCommits(List<CommitValue> commits, ProjectDB project){
        for (CommitValue commit: commits){
            Author author = commit.getAuthor();
            CommitDB commitDB = new CommitDB(commit.getHash(), null, commit.getMessage(), author.getUser().getNickname(),
                    author.getRaw(), commit.getDate(), commit.getLinks().getSelf().getHref());
            project.getCommits().add(commitDB);
        }
    }

    public void transformComments(List<CommentValue> comments, IssueDB issue) {
        for (CommentValue comment: comments) {
            UserDB author = transformUser(comment.getUser());
            CommentDB commentDB = new CommentDB(comment.getId(), comment.getContent().getRaw(), comment.getCreatedOn(), comment.getUpdatedOn(), author);
            issue.getComments().add(commentDB);
        }
    }

    public UserDB transformUser(User user){
        return new UserDB(user.getUuid(), user.getNickname(), user.getDisplayName(), user.getLinks().getAvatar().getHref(), user.getLinks().getSelf().getHref());
    }
}