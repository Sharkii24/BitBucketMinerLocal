
package aiss.bitbucketminer.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {

    @JsonProperty("values")
    private List<CommitValue> values; // Hace falta
    /*
    @JsonProperty("pagelen")
    private Integer pagelen;
    @JsonProperty("next")
    private String next;

     */

    @JsonProperty("values")
    public List<CommitValue> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<CommitValue> values) {
        this.values = values;
    }

    /*
    @JsonProperty("pagelen")
    public Integer getPagelen() {
        return pagelen;
    }

    @JsonProperty("pagelen")
    public void setPagelen(Integer pagelen) {
        this.pagelen = pagelen;
    }

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Commit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("values");
        sb.append('=');
        sb.append(((this.values == null)?"<null>":this.values));
        sb.append(',');
        /*
        sb.append("pagelen");
        sb.append('=');
        sb.append(((this.pagelen == null)?"<null>":this.pagelen));
        sb.append(',');
        sb.append("next");
        sb.append('=');
        sb.append(((this.next == null)?"<null>":this.next));
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
