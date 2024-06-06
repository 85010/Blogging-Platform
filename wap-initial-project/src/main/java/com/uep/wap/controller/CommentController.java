package com.uep.wap.controller;

import com.uep.wap.dto.CommentDTO;
import com.uep.wap.model.Comment;
import com.uep.wap.service.CommentService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/")
    public String addComment(@RequestBody CommentDTO commentDTO) {
        commentService.addComment(commentDTO);
        return "Comment added!";
    }

    @GetMapping(path = "/user/{userId}")
    public Iterable<Comment> getUserPosts(@PathVariable int userId) {
        return commentService.getUserComments(userId);
    }
}