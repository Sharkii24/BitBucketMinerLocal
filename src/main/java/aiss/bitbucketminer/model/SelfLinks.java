
package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SelfLinks {

    @JsonProperty("self")
    private Link self;   // Hace falta (web_url Commit)

    /*
    @JsonProperty("html")
    private Html__1 html;
    @JsonProperty("diff")
    private Diff diff;
    @JsonProperty("approve")
    private Approve approve;
    @JsonProperty("comments")
    private Comments comments;
    @JsonProperty("statuses")
    private Statuses statuses;
    @JsonProperty("patch")
    private Patch patch;

     */

    @JsonProperty("self")
    public Link getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Link self) {
        this.self = self;
    }

    /*
    @JsonProperty("html")
    public Html__1 getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(Html__1 html) {
        this.html = html;
    }

    @JsonProperty("diff")
    public Diff getDiff() {
        return diff;
    }

    @JsonProperty("diff")
    public void setDiff(Diff diff) {
        this.diff = diff;
    }

    @JsonProperty("approve")
    public Approve getApprove() {
        return approve;
    }

    @JsonProperty("approve")
    public void setApprove(Approve approve) {
        this.approve = approve;
    }

    @JsonProperty("comments")
    public Comments getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(Comments comments) {
        this.comments = comments;
    }

    @JsonProperty("statuses")
    public Statuses getStatuses() {
        return statuses;
    }

    @JsonProperty("statuses")
    public void setStatuses(Statuses statuses) {
        this.statuses = statuses;
    }

    @JsonProperty("patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SelfLinks.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("self");
        sb.append('=');
        sb.append(((this.self == null)?"<null>":this.self));
        sb.append(',');
        /*
        sb.append("html");
        sb.append('=');
        sb.append(((this.html == null)?"<null>":this.html));
        sb.append(',');
        sb.append("diff");
        sb.append('=');
        sb.append(((this.diff == null)?"<null>":this.diff));
        sb.append(',');
        sb.append("approve");
        sb.append('=');
        sb.append(((this.approve == null)?"<null>":this.approve));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
        sb.append(',');
        sb.append("statuses");
        sb.append('=');
        sb.append(((this.statuses == null)?"<null>":this.statuses));
        sb.append(',');
        sb.append("patch");
        sb.append('=');
        sb.append(((this.patch == null)?"<null>":this.patch));
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
