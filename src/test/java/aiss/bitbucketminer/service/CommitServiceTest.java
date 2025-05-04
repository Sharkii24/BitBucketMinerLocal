package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.CommitValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommitServiceTest {

    @Autowired
    private CommitService commitService;

    @Test
    @DisplayName("List of Commit")
    void getCommits() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        String nCommits = "15";
        List<CommitValue> commits = null;
        commits = commitService.getCommits(owner, repo, nCommits);
        assertFalse(commits.isEmpty(), "The list of commits is empty!");
        System.out.println(commits);
    }

    @Test
    @DisplayName("List of Commit by Id")
    void getCommitId() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        String id = "67a0362b29f34c45251ce88c5851756fb30a65cc";
        CommitValue commit = null;
        commit = commitService.getCommitId(owner, repo, id);
        assertFalse(commit == null, "The commit is null!");
        System.out.println(commit);
    }

    @Test
    @DisplayName("List of Commit with max pages")
    void getCommitsMaxPages() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        String nCommits = "3";
        String maxPages = "5";
        List<CommitValue> commits = null;
        commits = commitService.getCommitsMaxPages(owner, repo, nCommits, maxPages);
        assertFalse(commits.isEmpty(), "The list of commits is empty!");
        System.out.println(commits);
    }
}