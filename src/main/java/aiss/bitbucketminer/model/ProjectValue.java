
package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectValue {

    @JsonProperty("uuid")
    private String uuid;  // Hace falta (id Project)
    @JsonProperty("name")
    private String name;    // Hace falta (name Project)
    @JsonProperty("links")
    private SelfLinks links;    // Hace falta (web_url Project)
    @JsonProperty("slug")
    private String slug;    // Hace falta (Get a Project)

    /*
    @JsonProperty("type")
    private String type;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("scm")
    private String scm;
    @JsonProperty("website")
    private String website;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("workspace")
    private Workspace workspace;
    @JsonProperty("is_private")
    private Boolean isPrivate;
    @JsonProperty("project")
    private Project__1 project;
    @JsonProperty("fork_policy")
    private String forkPolicy;
    @JsonProperty("created_on")
    private String createdOn;
    @JsonProperty("updated_on")
    private String updatedOn;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("language")
    private String language;
    @JsonProperty("mainbranch")
    private Mainbranch mainbranch;
    @JsonProperty("override_settings")
    private OverrideSettings overrideSettings;
    @JsonProperty("parent")
    private Object parent;
    @JsonProperty("enforced_signed_commits")
    private Object enforcedSignedCommits;
    @JsonProperty("has_issues")
    private Boolean hasIssues;
    @JsonProperty("has_wiki")
    private Boolean hasWiki;

     */

    @JsonProperty("links")
    public SelfLinks getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(SelfLinks links) {
        this.links = links;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
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

    @JsonProperty("full_name")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("scm")
    public String getScm() {
        return scm;
    }

    @JsonProperty("scm")
    public void setScm(String scm) {
        this.scm = scm;
    }

    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("workspace")
    public Workspace getWorkspace() {
        return workspace;
    }

    @JsonProperty("workspace")
    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    @JsonProperty("is_private")
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    @JsonProperty("is_private")
    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @JsonProperty("project")
    public Project__1 getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Project__1 project) {
        this.project = project;
    }

    @JsonProperty("fork_policy")
    public String getForkPolicy() {
        return forkPolicy;
    }

    @JsonProperty("fork_policy")
    public void setForkPolicy(String forkPolicy) {
        this.forkPolicy = forkPolicy;
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

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }



    @JsonProperty("mainbranch")
    public Mainbranch getMainbranch() {
        return mainbranch;
    }

    @JsonProperty("mainbranch")
    public void setMainbranch(Mainbranch mainbranch) {
        this.mainbranch = mainbranch;
    }

    @JsonProperty("override_settings")
    public OverrideSettings getOverrideSettings() {
        return overrideSettings;
    }

    @JsonProperty("override_settings")
    public void setOverrideSettings(OverrideSettings overrideSettings) {
        this.overrideSettings = overrideSettings;
    }

    @JsonProperty("parent")
    public Object getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(Object parent) {
        this.parent = parent;
    }

    @JsonProperty("enforced_signed_commits")
    public Object getEnforcedSignedCommits() {
        return enforcedSignedCommits;
    }

    @JsonProperty("enforced_signed_commits")
    public void setEnforcedSignedCommits(Object enforcedSignedCommits) {
        this.enforcedSignedCommits = enforcedSignedCommits;
    }

    @JsonProperty("has_issues")
    public Boolean getHasIssues() {
        return hasIssues;
    }

    @JsonProperty("has_issues")
    public void setHasIssues(Boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    @JsonProperty("has_wiki")
    public Boolean getHasWiki() {
        return hasWiki;
    }

    @JsonProperty("has_wiki")
    public void setHasWiki(Boolean hasWiki) {
        this.hasWiki = hasWiki;
    }
     */


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProjectValue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("uuid");
        sb.append('=');
        sb.append(((this.uuid == null)?"<null>":this.uuid));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("slug");
        sb.append('=');
        sb.append(((this.slug == null)?"<null>":this.slug));
        sb.append(',');
        /*
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("scm");
        sb.append('=');
        sb.append(((this.scm == null)?"<null>":this.scm));
        sb.append(',');
        sb.append("website");
        sb.append('=');
        sb.append(((this.website == null)?"<null>":this.website));
        sb.append(',');
        sb.append("owner");
        sb.append('=');
        sb.append(((this.owner == null)?"<null>":this.owner));
        sb.append(',');
        sb.append("workspace");
        sb.append('=');
        sb.append(((this.workspace == null)?"<null>":this.workspace));
        sb.append(',');
        sb.append("isPrivate");
        sb.append('=');
        sb.append(((this.isPrivate == null)?"<null>":this.isPrivate));
        sb.append(',');
        sb.append("project");
        sb.append('=');
        sb.append(((this.project == null)?"<null>":this.project));
        sb.append(',');
        sb.append("forkPolicy");
        sb.append('=');
        sb.append(((this.forkPolicy == null)?"<null>":this.forkPolicy));
        sb.append(',');
        sb.append("createdOn");
        sb.append('=');
        sb.append(((this.createdOn == null)?"<null>":this.createdOn));
        sb.append(',');
        sb.append("updatedOn");
        sb.append('=');
        sb.append(((this.updatedOn == null)?"<null>":this.updatedOn));
        sb.append(',');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("mainbranch");
        sb.append('=');
        sb.append(((this.mainbranch == null)?"<null>":this.mainbranch));
        sb.append(',');
        sb.append("overrideSettings");
        sb.append('=');
        sb.append(((this.overrideSettings == null)?"<null>":this.overrideSettings));
        sb.append(',');
        sb.append("parent");
        sb.append('=');
        sb.append(((this.parent == null)?"<null>":this.parent));
        sb.append(',');
        sb.append("enforcedSignedCommits");
        sb.append('=');
        sb.append(((this.enforcedSignedCommits == null)?"<null>":this.enforcedSignedCommits));
        sb.append(',');
        sb.append("hasIssues");
        sb.append('=');
        sb.append(((this.hasIssues == null)?"<null>":this.hasIssues));
        sb.append(',');
        sb.append("hasWiki");
        sb.append('=');
        sb.append(((this.hasWiki == null)?"<null>":this.hasWiki));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("fullName");
        sb.append('=');
        sb.append(((this.fullName == null)?"<null>":this.fullName));
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
