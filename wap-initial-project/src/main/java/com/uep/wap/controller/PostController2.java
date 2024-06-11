package com.uep.wap.controller;

import com.uep.wap.model.Post;
import com.uep.wap.service.PostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(path = "/posts")
public class PostController2 {

    private final PostService postService;

    public PostController2(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/by-category/{id}")
    public String getPostsFromCategory(@PathVariable int id, Model model) {
        List<Post> posts = postService.findPostsByCategoryId(id);
        model.addAttribute("posts", posts);
        return "posts_by_category";
    }    
}