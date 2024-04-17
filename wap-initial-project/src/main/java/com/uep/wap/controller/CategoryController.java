package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private final UsersService usersService;

    public CategoryController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/")
    public Iterable<User> getAllCategories(){
        return usersService.getAllCategories();
    }

    @PostMapping(path = "/")
    public String addCategory(@RequestBody UserDTO userDTO){
        usersService.addCategory(userDTO);
        return "Category added!";
    }
}
