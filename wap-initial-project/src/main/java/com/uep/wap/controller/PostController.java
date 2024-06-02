package com.uep.wap.controller;

import com.uep.wap.model.Comment;
import com.uep.wap.model.Post;
import com.uep.wap.model.User;
import com.uep.wap.repository.CommentRepository;
import com.uep.wap.repository.PostRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/new")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("users", userRepository.findAll());
        return "new-post";
    }

    @PostMapping("/new")
    public String addPost(@ModelAttribute Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-post";
        }
        postRepository.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable("id") Integer id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        model.addAttribute("users", userRepository.findAll());
        return "edit-post";
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable("id") Integer id, @ModelAttribute Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            post.setId(id);
            return "edit-post";
        }
        postRepository.save(post);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Integer id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        postRepository.delete(post);
        return "redirect:/";
    }

    @PostMapping("/comment/{postId}")
    public String addComment(@PathVariable("postId") Integer postId, @ModelAttribute Comment comment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/";
        }
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + postId));
        comment.setParentPost(post);
        commentRepository.save(comment);
        return "redirect:/";
    }

    @GetMapping("/comment/edit/{id}")
    public String editCommentForm(@PathVariable("id") Integer id, Model model) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment Id:" + id));
        model.addAttribute("comment", comment);
        return "edit-comment";
    }

    @PostMapping("/comment/update/{id}")
    public String updateComment(@PathVariable("id") Integer id, @ModelAttribute Comment comment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            comment.setId(id);
            return "edit-comment";
        }
        commentRepository.save(comment);
        return "redirect:/";
    }

    @GetMapping("/comment/delete/{id}")
    public String deleteComment(@PathVariable("id") Integer id, Model model) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment Id:" + id));
        commentRepository.delete(comment);
        return "redirect:/";
    }
}