
package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLinks {

    @JsonProperty("avatar")
    private Link avatar;   // Hace falta (avatarUrl User)
    @JsonProperty("self")
    private Link self;   // Hace falta (web_url User)

    /*
    @JsonProperty("html")
    private A html;

     */

    @JsonProperty("self")
    public Link getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Link self) {
        this.self = self;
    }

    @JsonProperty("avatar")
    public Link getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(Link avatar) {
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
        sb.append(UserLinks.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
