package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.Issue;
import aiss.bitbucketminer.model.IssueValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bitbucketminer.baseUri}" + "repositories/")
    private String baseUri;

    // Service to list Issues
    public List<IssueValue> getIssues(String owner, String repo, String nIssues) {
        String uri = baseUri + owner + "/" + repo + "/issues?pagelen=" + nIssues;
        ResponseEntity<Issue> response = restTemplate.exchange(uri, HttpMethod.GET, null, Issue.class);
        return response.getBody().getValues();
    }

    public IssueValue getIssueByNumber(String owner, String repo, String id) {
        String uri = baseUri + owner + "/" + repo + "/issues/" + id;
        ResponseEntity<IssueValue> response = restTemplate.exchange(uri, HttpMethod.GET, null, IssueValue.class);
        return response.getBody();
    }

    public List<IssueValue> getIssuesMaxPages(String owner, String repo, String nIssues, String maxPages) {
        List<IssueValue> issues = new ArrayList<>();
        String uri = baseUri + owner + "/" + repo + "/issues?pagelen=" + nIssues;
        ResponseEntity<Issue> response = restTemplate.exchange(uri, HttpMethod.GET, null, Issue.class);
        Issue issueBody = response.getBody();
        issues.addAll(issueBody.getValues());
        if (Integer.parseInt(maxPages) > 1) {
            for (Integer i = 1; i < Integer.parseInt(maxPages); i++) {
                if (issueBody.getNext() == null) break;
                String uri2 = issueBody.getNext() + "&pagelen=" + nIssues;
                response = restTemplate.exchange(uri2, HttpMethod.GET, null, Issue.class);
                issues.addAll(response.getBody().getValues());
            }
        }
        return issues;
    }
}
