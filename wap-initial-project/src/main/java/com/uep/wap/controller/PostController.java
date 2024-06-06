package com.uep.wap.controller;

import com.uep.wap.model.Post;
import com.uep.wap.service.PostService;
import com.uep.wap.service.CategoryService;
import com.uep.wap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/new")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "new-post";
    }

    @PostMapping("/new")
    public String addPost(@ModelAttribute("post") Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.getAllUsers());
            model.addAttribute("categories", categoryService.getAllCategories());
            return "new-post";
        }
        postService.savePost(post);
        return "redirect:/posts";
    }

    @GetMapping
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }

    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable("id") Integer id, Model model) {
        Post post = postService.getPostById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "edit-post";
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable("id") Integer id, @ModelAttribute Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            post.setId(id);
            model.addAttribute("users", userService.getAllUsers());
            model.addAttribute("categories", categoryService.getAllCategories());
            return "edit-post";
        }
        postService.savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Integer id, Model model) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}