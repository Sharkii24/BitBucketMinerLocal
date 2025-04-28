package aiss.bitbucketminer.service;

import aiss.bitbucketminer.authorizationService.AuthorizationService;
import aiss.bitbucketminer.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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


}
