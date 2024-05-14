package com.uep.wap.service;

import com.uep.wap.dto.IUserStatisticsDTO;
import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getRole());
        userRepository.save(user);

        System.out.println("User added");
    }

    public List<IUserStatisticsDTO> getByMostUpvotes() {
        List<IUserStatisticsDTO> usersStatistics = userRepository.findUsersWithMostUpvotes();

        return usersStatistics;
    }

    public List<IUserStatisticsDTO> getByMostComments() {
        List<IUserStatisticsDTO> usersStatistics = userRepository.findUsersWithMostComments();

        return usersStatistics;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}


