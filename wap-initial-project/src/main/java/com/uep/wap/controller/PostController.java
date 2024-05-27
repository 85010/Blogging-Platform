package com.uep.wap.controller;
import com.uep.wap.dto.PostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.service.PostService;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
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
    @GetMapping(path = "/user/{userId}")
    public Iterable<Post> getUserPosts(@PathVariable int userId) {
        return postService.getUserPosts(userId);
    }

    @GetMapping(path = "/category/{categoryId}")
    public Iterable<Post> getCategoryPosts(@PathVariable int categoryId) {
        return postService.getPostsFromCategory(categoryId);
    }

    @GetMapping(path = "/latest")
    public Iterable<Post> getLatestPost() {
        return postService.getLatestPosts();
    }
}
