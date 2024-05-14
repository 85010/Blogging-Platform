package com.uep.wap.repository;
import com.uep.wap.model.Comment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
     @Query(value = "SELECT c.* FROM comments c WHERE c.author_id=?1", nativeQuery = true)
    List<Comment> findUserComments(int userId);
}
