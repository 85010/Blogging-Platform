package com.uep.wap.controller;

import com.uep.wap.dto.NewCommentDTO;
import com.uep.wap.model.Comment;
import com.uep.wap.service.CommentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path = "/")
    public Iterable<Comment> getAllComments() {
        return commentService.getAllComments();
    }

//    @PostMapping(path = "/")
//    public String addComment(@RequestBody NewCommentDTO commentDTO) {
//        commentService.addComment(commentDTO);
//        return "Comment added!";
//    }

    @PostMapping(path = "/")
    public RedirectView addComment(@RequestParam int postId, @ModelAttribute Comment comment) {

        NewCommentDTO newComment = new NewCommentDTO();
        newComment.setParentPost(postId);
        newComment.setContent(comment.getContent());
        newComment.setAuthorId(comment.getAuthor().getId());

        commentService.addComment(newComment);
        return new RedirectView("/");
    }

    @GetMapping(path = "/user/{userId}")
    public Iterable<Comment> getUserPosts(@PathVariable int userId) {
        return commentService.getUserComments(userId);
    }
}