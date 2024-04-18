package com.uep.wap.service;
import com.uep.wap.dto.PostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.repository.PostRepository;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void addPost(PostDTO postDTO) {
        long currentTime = Instant.now().getEpochSecond();

        Post post = new Post(postDTO.getContent(), postDTO.getCategory(), currentTime, postDTO.getAuthor(), postDTO.getTags());
        postRepository.save(post);

        System.out.println("Post added");
    }

    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }
}

