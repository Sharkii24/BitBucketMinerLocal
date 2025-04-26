
package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentValue {

    @JsonProperty("id")
    private Integer id;      // Hace falta (id Comment)
    @JsonProperty("created_on")
    private String createdOn;       // Hace falta (createdAt Comment)
    @JsonProperty("updated_on")
    private Object updatedOn;       // Hace falta (updatedAt Comment)
    @JsonProperty("content")
    private CommentContent content; // Hace falta (body Comment)
    @JsonProperty("user")
    private User user;  // Hace falta (author Comment)

    /*
    @JsonProperty("type")
    private String type;
    @JsonProperty("issue")
    private Issue issue;
    @JsonProperty("links")
    private Links__3 links;
     */

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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
    public Object getUpdatedOn() {
        return updatedOn;
    }

    @JsonProperty("updated_on")
    public void setUpdatedOn(Object updatedOn) {
        this.updatedOn = updatedOn;
    }

    @JsonProperty("content")
    public CommentContent getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(CommentContent content) {
        this.content = content;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
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

    @JsonProperty("issue")
    public Issue getIssue() {
        return issue;
    }

    @JsonProperty("issue")
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @JsonProperty("links")
    public Links__3 getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links__3 links) {
        this.links = links;
    }

     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommentValue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("createdOn");
        sb.append('=');
        sb.append(((this.createdOn == null)?"<null>":this.createdOn));
        sb.append(',');
        sb.append("updatedOn");
        sb.append('=');
        sb.append(((this.updatedOn == null)?"<null>":this.updatedOn));
        sb.append(',');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null)?"<null>":this.content));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');

        /*
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("issue");
        sb.append('=');
        sb.append(((this.issue == null)?"<null>":this.issue));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
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
