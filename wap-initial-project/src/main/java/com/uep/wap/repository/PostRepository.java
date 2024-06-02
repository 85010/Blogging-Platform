package com.uep.wap.repository;
import com.uep.wap.model.Post;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findByContentContaining(String content);
    
    @Query(value = "SELECT p.* FROM posts p ORDER BY p.created_at DESC LIMIT 10", nativeQuery = true)
    List<Post> findLatestPosts();

    @Query(value = "SELECT p.* FROM posts p WHERE p.author_id=?1", nativeQuery = true)
    List<Post> findUserPosts(int userId);

    @Query(value = "SELECT p.* FROM posts p WHERE p.category_id=?1", nativeQuery = true)
    List<Post> findPostsByCategoryId(int category_id);
}
