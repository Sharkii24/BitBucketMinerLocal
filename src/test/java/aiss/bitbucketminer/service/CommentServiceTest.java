package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.CommentValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Test
    @DisplayName("List of Comment on an Issue Id")
    void getComments() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        String issueId = "80";
        List<CommentValue> comments = null;
        comments = commentService.getComments(owner, repo, issueId);
        assertFalse(comments.isEmpty(), "The list of comments is empty!");
        System.out.println(comments);
    }

    @Test
    @DisplayName("List of Comment by Id")
    void getCommentById() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        String issueId = "80";
        String id = "55980340";
        CommentValue comment = null;
        comment = commentService.getCommentById(owner, repo, issueId, id);
        assertFalse(comment == null, "The comment is null!");
        System.out.println(comment);
    }
}