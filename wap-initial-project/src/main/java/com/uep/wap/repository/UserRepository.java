package com.uep.wap.repository;

import com.uep.wap.dto.IUserStatisticsDTO;
import com.uep.wap.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT u.id as id, u.username as username, COALESCE(SUM(p.upvotes + c.upvotes), 0) as value \n" +
            "FROM users u\n" +
            "LEFT JOIN posts p ON p.author_id=u.id\n" +
            "LEFT JOIN comments c ON c.author_id=u.id\n" +
            "GROUP BY u.id\n" +
            "ORDER BY SUM(p.upvotes + c.upvotes) DESC\n" +
            "LIMIT 10", nativeQuery = true)
    List<IUserStatisticsDTO> findUsersWithMostUpvotes();

    @Query(value = "SELECT u.id as id, u.username as username, COALESCE(COUNT(c.id), 0) as value\n" +
            "FROM users u\n" +
            "LEFT JOIN comments c ON c.creator_id=u.id\n" +
            "GROUP BY u.id\n" +
            "ORDER BY COUNT(c.id) DESC\n" +
            "LIMIT 10", nativeQuery = true)
    List<IUserStatisticsDTO> findUsersWithMostComments();
}
