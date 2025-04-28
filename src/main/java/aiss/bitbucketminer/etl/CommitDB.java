package aiss.bitbucketminer.etl;

public class CommitDB {

    private String id;
    private String message;

    public CommitDB(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
     */

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}