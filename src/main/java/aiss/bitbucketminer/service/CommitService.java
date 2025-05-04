package aiss.bitbucketminer.service;

import aiss.bitbucketminer.authorizationService.AuthorizationService;
import aiss.bitbucketminer.model.*;
import aiss.bitbucketminer.utils.RESTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommitService {

    @Autowired
    AuthorizationService authorizationService;

    @Value("${bitbucketminer.baseUri}" + "repositories/")
    private String baseUri;

    // Service to list Issues
    public List<CommitValue> getCommits(String owner, String repo, String nCommits) {
        String uri = baseUri + owner + "/" + repo + "/commits?pagelen=" + nCommits;
        ResponseEntity<Commit> response = authorizationService.getWithToken(uri, Commit.class);
        return response.getBody().getValues();
    }

    public CommitValue getCommitId(String owner, String repo, String id) {
        String uri = baseUri + owner + "/" + repo + "/commit/" + id;
        ResponseEntity<CommitValue> response = authorizationService.getWithToken(uri, CommitValue.class);
        return response.getBody();
    }

    public List<CommitValue> getCommitsMaxPages(String owner, String repo, String nCommits, String maxPages) {
        List<CommitValue> commits = new ArrayList<>();
        String uri = baseUri + owner + "/" + repo + "/commits?pagelen=" + nCommits;
        ResponseEntity<Commit> response = authorizationService.getWithToken(uri, Commit.class);
        Commit commitBody = response.getBody();
        commits.addAll(commitBody.getValues());
        if (Integer.parseInt(maxPages) > 1) {
            for (Integer i = 1; i < Integer.parseInt(maxPages); i++) {
                if (commitBody.getNext() == null) break;
                String uri2 = commitBody.getNext()+"&pagelen="+ nCommits;
                response = authorizationService.getWithToken(uri2, Commit.class);
                commits.addAll(response.getBody().getValues());
            }
        }
        return commits;
    }
}
