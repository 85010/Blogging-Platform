package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tags")
public class TagController {

    private final UsersService usersService;

    public TagController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/")
    public Iterable<User> getAllTags(){
        return usersService.getAllTags();
    }

    @PostMapping(path = "/")
    public String addTag(@RequestBody UserDTO userDTO){
        usersService.addTag(userDTO);
        return "Tag added!";
    }
}
