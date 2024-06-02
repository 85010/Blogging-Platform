package com.uep.wap.controller;

import com.uep.wap.model.Post;
import com.uep.wap.repository.PostRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HomeController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model) {
        List<Post> posts = StreamSupport
                .stream(postRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new Post()); 
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Post> posts = postRepository.findByContentContaining(query);
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new Post());
        return "index";
    }

    @GetMapping("/home/edit/{id}")
    public String editPostForm(@PathVariable("id") Integer id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        model.addAttribute("users", userRepository.findAll());
        return "edit-post";
    }
}