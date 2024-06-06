package com.uep.wap.controller;

import com.uep.wap.dto.NewPostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.service.PostService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/")
    public Iterable<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping(path = "/")
    public String addPost(@RequestBody NewPostDTO postDTO) {
        postService.addPost(postDTO);

        return "Post added";
    }

    @GetMapping(path = "/{postId}")
    public Optional<Post> getPostById(@PathVariable int postId) {
        return postService.getPostById(postId);
    }

    @GetMapping(path = "/user/{userId}")
    public Iterable<Post> getUserPost(@PathVariable int userId) {
        return postService.getUserPosts(userId);
    }

    @GetMapping(path = "/category/{categoryId}")
    public Iterable<Post> getCategoryPosts(@PathVariable int categoryId) { 
        return postService.getPostsFromCategory(categoryId);
    }

    @GetMapping(path = "/latest")
    public Iterable<Post> getLatestPosts() {
        return postService.getLatestPosts();
    }
}