package com.uep.wap.repository;

import com.uep.wap.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    //kwestia czy to extends Crudrepo ma byc tak jak w przykladzie czy my tutaj mamy cos innego dac, gacek tez ma Crud wiec uznalbym ze tak ma byc
}
