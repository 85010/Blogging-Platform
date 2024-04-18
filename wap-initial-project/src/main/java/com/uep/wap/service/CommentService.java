package com.uep.wap.service;
import com.uep.wap.dto.CommentDTO;
import com.uep.wap.model.Comment;
import com.uep.wap.repository.CommentRepository;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void addComment(CommentDTO commentDTO) {
        long currentTime = Instant.now().getEpochSecond();

        Comment comment = new Comment(commentDTO.getContent(), commentDTO.getAuthor(), currentTime, commentDTO.getParentPost());
        commentRepository.save(comment);

        System.out.println("Comment added");
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}

