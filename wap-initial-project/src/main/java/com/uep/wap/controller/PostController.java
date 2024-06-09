package com.uep.wap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.uep.wap.dto.NewPostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.model.User;
import com.uep.wap.repository.PostRepository;
import com.uep.wap.service.PostService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
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
        System.out.println(postDTO);

        postService.addPost(postDTO);

        return "Post added";
    }

    @PostMapping(path = "/new")
    public RedirectView savePost(@ModelAttribute Post post) throws JsonProcessingException {
        System.out.println("2");
        System.out.println(new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true).writeValueAsString(post));

        NewPostDTO newPost = new NewPostDTO();
        newPost.setAuthorId(post.getAuthor().getId());
        newPost.setContent(post.getContent());
        newPost.setUpvotes(post.getUpvotes());
        newPost.setCategoryId(post.getCategory().getId());
        newPost.setCreateDate(new Date().getTime());
        newPost.setLastEdited(new Date().getTime());

        postService.addPost(newPost);

        return new RedirectView("/");
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