package aiss.bitbucketminer.etl;

import java.util.ArrayList;
import java.util.List;

public class IssueDB {

    private String id;
    private String title;
    private String description;
    private String state;
    private String createdAt;
    private String updatedAt;
    private String closedAt;
    private List<String> labels;
    private Integer votes;
    private UserDB author;
    private UserDB assignee;
    private List<CommentDB> comments;

    public IssueDB(String id, String title, String description, String state, String createdAt, String updatedAt, String closedAt, List<String> labels, Integer votes, UserDB author, UserDB assignee) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
        this.labels = labels;
        this.votes = votes;
        this.author = author;
        this.assignee = assignee;
        this.comments = new ArrayList<CommentDB>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public UserDB getAuthor() {
        return author;
    }

    public void setAuthor(UserDB author) {
        this.author = author;
    }

    public UserDB getAssignee() {
        return assignee;
    }

    public void setAssignee(UserDB assignee) {
        this.assignee = assignee;
    }

    public List<CommentDB> getComments() {
        return comments;
    }

    public void setComments(List<CommentDB> comments) {
        this.comments = comments;
    }
}