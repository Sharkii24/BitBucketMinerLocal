package aiss.bitbucketminer.service;

import aiss.bitbucketminer.authorizationService.AuthorizationService;
import aiss.bitbucketminer.model.Comment;
import aiss.bitbucketminer.model.CommentValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    AuthorizationService authorizationService;

    @Value("${bitbucketminer.baseUri}" + "repositories/")
    private String baseUri;

    // Service to list Comments
    public List<CommentValue> getComments(String owner, String repo, String issueId) {
        String uri = baseUri + owner + "/" + repo + "/issues/" + issueId + "/comments";
        ResponseEntity<Comment> response = authorizationService.getWithToken(uri,Comment.class);
        return response.getBody().getValues();
    }

    public List<CommentValue> getCommentsByUri(String uri) {
        ResponseEntity<Comment> response = authorizationService.getWithToken(uri,Comment.class);
        return response.getBody().getValues();
    }

    // Service to list a Comment
    public CommentValue getCommentById(String owner, String repo, String issueId, String id) {
        String uri = baseUri + owner + "/" + repo + "/issues/" + issueId + "/comments/" + id;
        ResponseEntity<CommentValue> response = authorizationService.getWithToken(uri, CommentValue.class);
        return response.getBody();
    }
}
