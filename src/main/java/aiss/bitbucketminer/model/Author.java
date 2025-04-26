
package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @JsonProperty("raw")
    private String raw; // Hace falta (authorEmail Commit), hay que parsearlo

    @JsonProperty("user")
    private User user;  // Hace falta

    /*
    @JsonProperty("type")
    private String type;
     */

    @JsonProperty("raw")
    public String getRaw() {
        return raw;
    }

    @JsonProperty("raw")
    public void setRaw(String raw) {
        this.raw = raw;
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
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Author.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("raw");
        sb.append('=');
        sb.append(((this.raw == null)?"<null>":this.raw));
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
         */
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
