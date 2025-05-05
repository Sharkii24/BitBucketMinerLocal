package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.IssueValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueServiceTest {

    @Autowired
    IssueService issueService;

    @Test
    @DisplayName("List of Issues")
    void getIssues() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        String nIssues = "5";
        List<IssueValue> issues = null;
        issues = issueService.getIssues(owner, repo, nIssues);
        assertFalse(issues.isEmpty(), "The list of issues is empty!");
        System.out.println(issues);
    }

    @Test
    @DisplayName("List of Issues by Id")
    void getIssueByNumber() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        String number = "87";
        IssueValue issue = null;
        issue = issueService.getIssueByNumber(owner, repo, number);
        assertFalse(issue == null, "The issue is null!");
        System.out.println(issue);
    }


    @Test
    @DisplayName("List of Issues with max pages")
    void getIssuesMaxPages() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        String nIssues = "1";
        String maxPages = "2";
        List<IssueValue> issues = null;
        issues = issueService.getIssuesMaxPages(owner, repo, nIssues, maxPages);
        assertFalse(issues.isEmpty(), "The list of comments is empty!");
        System.out.println(issues);
    }
}