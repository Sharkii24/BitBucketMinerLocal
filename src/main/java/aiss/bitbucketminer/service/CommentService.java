package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.Comment;
import aiss.bitbucketminer.model.CommentValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bitbucketminer.baseUri}" + "repositories/")
    private String baseUri;

    // Service to list Comments
    public List<CommentValue> getComments(String owner, String repo, String issueId) {
        String uri = baseUri + owner + "/" + repo + "/issues/" + issueId + "/comments";
        ResponseEntity<Comment> response = restTemplate.exchange(uri, HttpMethod.GET, null, Comment.class);
        return response.getBody().getValues();
    }

    public List<CommentValue> getCommentsMaxPages(String owner, String repo, String issueId, String maxPages) {
        List<CommentValue> comments = new ArrayList<>();
        String uri = baseUri + owner + "/" + repo + "/issues/" + issueId + "/comments";
        ResponseEntity<Comment> response = restTemplate.exchange(uri, HttpMethod.GET, null, Comment.class);
        Comment commentBody = response.getBody();
        comments.addAll(response.getBody().getValues());
        if (Integer.parseInt(maxPages) > 1) {
            for (Integer i = 1; i < Integer.parseInt(maxPages); i++) {
                if (commentBody.getNext() == null) break;
                String uri2 = commentBody.getNext();
                response = restTemplate.exchange(uri2, HttpMethod.GET, null, Comment.class);
                comments.addAll(response.getBody().getValues());
            }
        }
        return comments;
    }

    public List<CommentValue> getCommentsByUri(String uri) {
        ResponseEntity<Comment> response = restTemplate.exchange(uri, HttpMethod.GET, null, Comment.class);
        return response.getBody().getValues();
    }

    public List<CommentValue> getCommentsByUriMaxPages(String uri, String maxPages) {
        List<CommentValue> comments = new ArrayList<>();
        ResponseEntity<Comment> response = restTemplate.exchange(uri, HttpMethod.GET, null, Comment.class);
        Comment commentBody = response.getBody();
        comments.addAll(response.getBody().getValues());
        if (Integer.parseInt(maxPages) > 1) {
            for (Integer i = 1; i < Integer.parseInt(maxPages); i++) {
                if(commentBody.getNext() == null) break;
                String uri2 = commentBody.getNext();
                response = restTemplate.exchange(uri2, HttpMethod.GET, null, Comment.class);
                comments.addAll(response.getBody().getValues());
            }
        }
        return comments;
    }

    // Service to list a Comment
    public CommentValue getCommentById(String owner, String repo, String issueId, String id) {
        String uri = baseUri + owner + "/" + repo + "/issues/" + issueId + "/comments/" + id;
        ResponseEntity<CommentValue> response = restTemplate.exchange(uri, HttpMethod.GET, null, CommentValue.class);
        return response.getBody();
    }
}
