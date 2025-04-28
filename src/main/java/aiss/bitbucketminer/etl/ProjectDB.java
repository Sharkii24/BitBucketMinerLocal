package aiss.bitbucketminer.etl;

import java.util.ArrayList;
import java.util.List;

public class ProjectDB {

    private String id;
    private String name;
    private String web_url;
    private List<CommitDB> commits;
    private List<IssueDB> issues;

    public ProjectDB(String id, String name, String web_url){
        this.id = id;
        this.name = name;
        this.web_url = web_url;
        this.commits = new ArrayList<CommitDB>();
        this.issues = new ArrayList<IssueDB>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public List<CommitDB> getCommits() {
        return commits;
    }

    public void setCommits(List<CommitDB> commits) {
        this.commits = commits;
    }

    public List<IssueDB> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueDB> issues) {
        this.issues = issues;
    }
}