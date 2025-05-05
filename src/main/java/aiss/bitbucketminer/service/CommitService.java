package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommitService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bitbucketminer.baseUri}" + "repositories/")
    private String baseUri;

    // Service to list Issues
    public List<CommitValue> getCommits(String owner, String repo, String nCommits) {
        String uri = baseUri + owner + "/" + repo + "/commits?pagelen=" + nCommits;
        ResponseEntity<Commit> response = restTemplate.exchange(uri, HttpMethod.GET, null, Commit.class);
        return response.getBody().getValues();
    }

    public CommitValue getCommitId(String owner, String repo, String id) {
        String uri = baseUri + owner + "/" + repo + "/commit/" + id;
        ResponseEntity<CommitValue> response = restTemplate.exchange(uri, HttpMethod.GET, null, CommitValue.class);
        return response.getBody();
    }

    public List<CommitValue> getCommitsMaxPages(String owner, String repo, String nCommits, String maxPages) {
        List<CommitValue> commits = new ArrayList<>();
        String uri = baseUri + owner + "/" + repo + "/commits?pagelen=" + nCommits;
        ResponseEntity<Commit> response = restTemplate.exchange(uri, HttpMethod.GET, null, Commit.class);
        Commit commitBody = response.getBody();
        commits.addAll(commitBody.getValues());
        if (Integer.parseInt(maxPages) > 1) {
            for (Integer i = 1; i < Integer.parseInt(maxPages); i++) {
                if (commitBody.getNext() == null) break;
                String uri2 = commitBody.getNext()+"&pagelen="+ nCommits;
                response = restTemplate.exchange(uri2, HttpMethod.GET, null, Commit.class);
                commits.addAll(response.getBody().getValues());
            }
        }
        return commits;
    }
}
