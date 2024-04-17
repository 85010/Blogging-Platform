package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    private final UsersService usersService;

    public CommentController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/")
    public Iterable<User> getAllComments(){
        return usersService.getAllComments();
    }

    @PostMapping(path = "/")
    public String addComment(@RequestBody UserDTO userDTO){
        usersService.addComment(userDTO);
        return "Comment added!";
    }
}
