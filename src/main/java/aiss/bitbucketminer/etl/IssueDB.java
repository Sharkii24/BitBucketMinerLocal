package aiss.bitbucketminer.etl;

import java.util.ArrayList;
import java.util.List;

public class IssueDB {

    private String id;
    private String title;
    private String description;
    private String state;
    private String created_at;
    private String updated_at;
    private String closed_at;
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
        this.created_at = createdAt;
        this.updated_at = updatedAt;
        this.closed_at = closedAt;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getClosed_at() {
        return closed_at;
    }

    public void setClosed_at(String closed_at) {
        this.closed_at = closed_at;
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