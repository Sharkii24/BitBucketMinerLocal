
package aiss.bitbucketminer.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    @JsonProperty("values")
    private List<CommentValue> values; // Hace falta
    @JsonProperty("next")
    private String next;    // Hace falta (next page uri Comment)

    /*
    @JsonProperty("pagelen")
    private Integer pagelen;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("page")
    private Integer page;

     */

    @JsonProperty("values")
    public List<CommentValue> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<CommentValue> values) {
        this.values = values;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
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

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Comment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("values");
        sb.append('=');
        sb.append(((this.values == null)?"<null>":this.values));
        sb.append(',');
        sb.append("next");
        sb.append('=');
        sb.append(((this.next == null)?"<null>":this.next));
        sb.append(',');
        /*
        sb.append("pagelen");
        sb.append('=');
        sb.append(((this.pagelen == null)?"<null>":this.pagelen));
        sb.append(',');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null)?"<null>":this.page));
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
