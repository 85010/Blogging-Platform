package com.uep.wap.service;

import com.uep.wap.dto.CommentDTO;
import com.uep.wap.model.Comment;
import com.uep.wap.model.Post;
import com.uep.wap.model.User;
import com.uep.wap.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void addComment(CommentDTO commentDTO) {
        long currentTime = Instant.now().getEpochSecond();

        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setAuthor(new User(commentDTO.getAuthorId()));
        comment.setUpvotes(0);
        comment.setCreatedate(currentTime);
        comment.setLastEdited(currentTime);
        comment.setParentPost(new Post(commentDTO.getParentPostId()));
        commentRepository.save(comment);

        System.out.println("Comment added");
    }

    public void upvoteComment(int commentId, long userId) {
        System.out.println("Upvote:" + commentId + " from user: " + userId);
        Optional<Comment> targetComment = commentRepository.findById(commentId);

        if (targetComment.isEmpty()) {
            System.out.println("Comment doesn't exist");
            return;
        }

        Comment comment = targetComment.get();
        comment.setUpvotes(comment.getUpvotes() + 1);

        commentRepository.save(comment);
    }

    public List<Comment> getUserComments(int userId) {
        System.out.println("Getting user comments:" + userId);

        List<Comment> comments = commentRepository.findUserComments(userId);

        return comments;
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}