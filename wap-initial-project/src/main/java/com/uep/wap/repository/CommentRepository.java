package com.uep.wap.repository;

import com.uep.wap.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<User, Integer> {
}
