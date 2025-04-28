package aiss.bitbucketminer.service;

import aiss.bitbucketminer.authorizationService.AuthorizationService;
import aiss.bitbucketminer.model.Issue;
import aiss.bitbucketminer.model.IssueValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    AuthorizationService authorizationService;

    @Value("${bitbucketminer.baseUri}" + "repositories/")
    private String baseUri;

    // Service to list Issues
    public List<IssueValue> getIssues(String owner, String repo, String nIssues) {
        String uri = baseUri + owner + "/" + repo + "/issues?pagelen=" + nIssues;
        ResponseEntity<Issue> response = authorizationService.getWithToken(uri, Issue.class);
        return response.getBody().getValues();
    }

    public IssueValue getIssueByNumber(String owner, String repo, String id) {
        String uri = baseUri + owner + "/" + repo + "/issues/" + id;
        ResponseEntity<IssueValue> response = authorizationService.getWithToken(uri, IssueValue.class);
        return response.getBody();
    }
}
