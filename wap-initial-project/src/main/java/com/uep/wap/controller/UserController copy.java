package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/")
    public Iterable<User> getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping(path = "/")
    public String addUser(@RequestBody UserDTO userDTO){
        usersService.addUser(userDTO);
        return "User added!";
    }
}
