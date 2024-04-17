package com.uep.wap.service;

import com.uep.wap.model.User;
import com.uep.wap.repository.StudentRepository;
import com.uep.wap.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void addComment(CommentDTO commentDTO) {
        long currentTime = Instant.now().getEpochSecond();

        Comment comment = new Comment(commentDTO.getContent(), commentDTO.getAuthor(), currentTime, currentTime,);
        commentRepository.save(comment);

        System.out.println("Comment added");
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}

