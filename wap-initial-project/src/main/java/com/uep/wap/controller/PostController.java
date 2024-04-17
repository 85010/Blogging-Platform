package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private final UsersService usersService;

    public PostController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/")
    public Iterable<User> getAllPosts(){
        return usersService.getAllPosts();
    }

    @PostMapping(path = "/")
    public String addPost(@RequestBody UserDTO userDTO){
        usersService.addPost(userDTO);
        return "Post added!";
    }
}
