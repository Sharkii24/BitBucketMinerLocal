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
    @DisplayName("List of Comment on an Issue Id with Uri")
    void getCommentsByUri() {
        String uri = "https://api.bitbucket.org/2.0/repositories/gentlero/bitbucket-api/issues/80/comments";
        List<CommentValue> comments = null;
        comments = commentService.getCommentsByUri(uri);
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

    @Test
    @DisplayName("List of Comment on an Issue Id with max pages")
    void getCommentsMaxPages() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        String issueId = "80";
        String maxPages = "5";
        List<CommentValue> comments = null;
        comments = commentService.getCommentsMaxPages(owner, repo, issueId, maxPages);
        assertFalse(comments.isEmpty(), "The list of comments is empty!");
        System.out.println(comments);
    }

    @Test
    @DisplayName("List of Comment on an Issue with max pages by Uri")
    void getCommentsByUriMaxPages() {
        String uri = "https://api.bitbucket.org/2.0/repositories/gentlero/bitbucket-api/issues/80/comments";
        String maxPages = "5";
        List<CommentValue> comments = null;
        comments = commentService.getCommentsByUriMaxPages(uri, maxPages);
        assertFalse(comments.isEmpty(), "The list of comments is empty!");
        System.out.println(comments);
    }
}