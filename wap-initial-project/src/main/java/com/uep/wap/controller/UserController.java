package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(path = "/")
    public String addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return "User added!";
    }
}
