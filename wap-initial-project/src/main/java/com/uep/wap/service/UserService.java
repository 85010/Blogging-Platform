package com.uep.wap.service;

import com.uep.wap.model.User;
import com.uep.wap.repository.StudentRepository;
import com.uep.wap.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getRole());
        userRepository.save(user);

        System.out.println("User added");
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}


