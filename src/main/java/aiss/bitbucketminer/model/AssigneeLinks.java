
package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssigneeLinks {

    @JsonProperty("self")
    private Links self;   // Hace falta (web_url User)
    @JsonProperty("avatar")
    private Links avatar;   // Hace falta (avatarUrl User)

    /*
    @JsonProperty("html")
    private A html;

     */

    @JsonProperty("self")
    public Links getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Links self) {
        this.self = self;
    }

    @JsonProperty("avatar")
    public Links getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(Links avatar) {
        this.avatar = avatar;
    }

    /*
    @JsonProperty("html")
    public Html__3 getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(Html__3 html) {
        this.html = html;
    }
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AssigneeLinks.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("self");
        sb.append('=');
        sb.append(((this.self == null)?"<null>":this.self));
        sb.append(',');
        sb.append("avatar");
        sb.append('=');
        sb.append(((this.avatar == null)?"<null>":this.avatar));
        sb.append(',');
        /*
        sb.append("html");
        sb.append('=');
        sb.append(((this.html == null)?"<null>":this.html));
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
