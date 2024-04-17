package com.uep.wap.controller;
import com.uep.wap.dto.PostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.service.PostService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/")
    public Iterable<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping(path = "/")
    public String addPost(@RequestBody PostDTO postDTO){
        postService.addPost(postDTO);
        return "Post added!";
    }
}
