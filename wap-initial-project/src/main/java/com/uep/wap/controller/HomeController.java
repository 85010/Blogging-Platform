package com.uep.wap.controller;

import com.uep.wap.model.Post;
import com.uep.wap.model.Category;
import com.uep.wap.repository.PostRepository;
import com.uep.wap.repository.UserRepository;
import com.uep.wap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HomeController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String home(Model model) {
        List<Post> posts = StreamSupport
                .stream(postRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        List<Category> categories = categoryService.getAllCategories();
        
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new Post());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Post> posts = postRepository.findByContentContaining(query);
        List<Category> categories = categoryService.getAllCategories();
        
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new Post());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping("/home/edit/{id}")
    public String editPostForm(@PathVariable("id") Integer id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        List<Category> categories = categoryService.getAllCategories();
        
        model.addAttribute("post", post);
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("categories", categories);
        return "edit-post";
    }
}
