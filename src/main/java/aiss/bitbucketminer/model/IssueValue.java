
package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueValue {

    @JsonProperty("id")
    private String id; // Hace falta (id Issue)
    @JsonProperty("title")
    private String title;   // Hace falta (title Issue)
    @JsonProperty("reporter")
    private User reporter;   // Hace falta (author Issue)
    @JsonProperty("assignee")
    private User assignee;    // Hace falta
    @JsonProperty("created_on")
    private String createdOn;   // Hace falta (createdAt Issue)
    @JsonProperty("updated_on")
    private String updatedOn;   // Hace falta (updatedAt Issue)
    @JsonProperty("state")
    private String state;   // Hace falta (state Issue)
    @JsonProperty("kind")
    private String kind;  // Hace falta (label Issue)
    @JsonProperty("votes")
    private Integer votes;  //Hace falta (votes Issue)
    @JsonProperty("content")
    private IssueContent content;   // Hace falta (description Issue)

    /*
    @JsonProperty("type")
    private String type;
    @JsonProperty("repository")
    private Repository repository;
    @JsonProperty("links")
    private IssueLinks links;
    @JsonProperty("edited_on")
    private Object editedOn;
    @JsonProperty("milestone")
    private Milestone milestone;
    @JsonProperty("component")
    private Component component;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("version")
    private Object version;
    @JsonProperty("watches")
    private Integer watches;

     */

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("reporter")
    public User getReporter() {
        return reporter;
    }

    @JsonProperty("reporter")
    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    @JsonProperty("assignee")
    public User getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    @JsonProperty("created_on")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("created_on")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("updated_on")
    public String getUpdatedOn() {
        return updatedOn;
    }

    @JsonProperty("updated_on")
    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("votes")
    public Integer getVotes() {
        return votes;
    }

    @JsonProperty("votes")
    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    @JsonProperty("content")
    public IssueContent getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(IssueContent content) {
        this.content = content;
    }


    /*
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }



    @JsonProperty("repository")
    public Repository getRepository() {
        return repository;
    }

    @JsonProperty("repository")
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @JsonProperty("links")
    public IssueLinks getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(IssueLinks links) {
        this.links = links;
    }

    @JsonProperty("edited_on")
    public Object getEditedOn() {
        return editedOn;
    }

    @JsonProperty("edited_on")
    public void setEditedOn(Object editedOn) {
        this.editedOn = editedOn;
    }

    @JsonProperty("milestone")
    public Milestone getMilestone() {
        return milestone;
    }

    @JsonProperty("milestone")
    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    @JsonProperty("component")
    public Component getComponent() {
        return component;
    }

    @JsonProperty("component")
    public void setComponent(Component component) {
        this.component = component;
    }

    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    @JsonProperty("version")
    public Object getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Object version) {
        this.version = version;
    }

    @JsonProperty("watches")
    public Integer getWatches() {
        return watches;
    }

    @JsonProperty("watches")
    public void setWatches(Integer watches) {
        this.watches = watches;
    }
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IssueValue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("reporter");
        sb.append('=');
        sb.append(((this.reporter == null)?"<null>":this.reporter));
        sb.append(',');
        sb.append("assignee");
        sb.append('=');
        sb.append(((this.assignee == null)?"<null>":this.assignee));
        sb.append(',');
        sb.append("createdOn");
        sb.append('=');
        sb.append(((this.createdOn == null)?"<null>":this.createdOn));
        sb.append(',');
        sb.append("updatedOn");
        sb.append('=');
        sb.append(((this.updatedOn == null)?"<null>":this.updatedOn));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("kind");
        sb.append('=');
        sb.append(((this.kind == null)?"<null>":this.kind));
        sb.append(',');
        sb.append("votes");
        sb.append('=');
        sb.append(((this.votes == null)?"<null>":this.votes));
        sb.append(',');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null)?"<null>":this.content));
        sb.append(',');

        /*
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("repository");
        sb.append('=');
        sb.append(((this.repository == null)?"<null>":this.repository));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("editedOn");
        sb.append('=');
        sb.append(((this.editedOn == null)?"<null>":this.editedOn));
        sb.append(',');
        sb.append("milestone");
        sb.append('=');
        sb.append(((this.milestone == null)?"<null>":this.milestone));
        sb.append(',');
        sb.append("component");
        sb.append('=');
        sb.append(((this.component == null)?"<null>":this.component));
        sb.append(',');
        sb.append("priority");
        sb.append('=');
        sb.append(((this.priority == null)?"<null>":this.priority));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("watches");
        sb.append('=');
        sb.append(((this.watches == null)?"<null>":this.watches));
        sb.append(',');
         */
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
