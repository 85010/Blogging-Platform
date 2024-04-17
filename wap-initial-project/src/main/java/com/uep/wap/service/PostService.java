package com.uep.wap.service;

import com.uep.wap.model.User;
import com.uep.wap.repository.StudentRepository;
import com.uep.wap.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void addPost(PostDTO postDTO) {
        

        Post post = new Post(postDTO.getPost(), postDTO.getAuthor(), currentTime, currentTime, postDTO.getCategory(), postDTO.getTags());
        questionRepository.save(question);

        System.out.println("Post added");
    }

    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }
}

