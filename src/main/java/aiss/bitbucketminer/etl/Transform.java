package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.CommitValue;
import aiss.bitbucketminer.model.IssueValue;
import aiss.bitbucketminer.model.ProjectValue;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Transform {

    public ProjectDB transform(ProjectValue project, List<CommitValue> commits, List<IssueValue> issues){
        ProjectDB projectDB = transformProject(project);
        transformIssues(issues,projectDB);
        transformCommits(commits,projectDB);
        return projectDB;
    }

    public ProjectDB transformProject(ProjectValue project){
        ProjectDB projectDB = new ProjectDB(project.getUuid(), project.getName(), project.getLinks().getSelf().getHref());
        return projectDB;
    }

    public void transformIssues(List<IssueValue> issues, ProjectDB project){
        for (IssueValue issue: issues){
            IssueDB issueDB = new IssueDB(issue.getId(),issue.getTitle());
            project.getIssues().add(issueDB);
        }
    }

    public void transformCommits(List<CommitValue> commits, ProjectDB project){
        for (CommitValue commit: commits){
            CommitDB commitDB = new CommitDB(commit.getHash(),commit.getMessage());
            project.getCommits().add(commitDB);
        }
    }
}