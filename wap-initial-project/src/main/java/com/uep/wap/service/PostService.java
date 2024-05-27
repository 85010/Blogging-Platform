package com.uep.wap.service;

import com.uep.wap.dto.NewPostDTO;
import com.uep.wap.dto.PostDTO;
import com.uep.wap.model.Category;
import com.uep.wap.model.Post;
import com.uep.wap.model.User;
import com.uep.wap.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void addPost(PostDTO postDTO) {
        long currentTime = Instant.now().getEpochSecond();

        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setCreatedate(currentTime);
        post.setLastEdited(currentTime);
        post.setAuthor(new User(postDTO.getAuthorId()));
        post.setCategory(new Category(postDTO.getCategoryId()));
        post.setUpvotes(1);

        postRepository.save(post);

        System.out.println("Post added");
    }

    public void upvotePost(int postId, long userId) {
        System.out.println("Upvote:" + postId + " from user: " + userId);
        Optional<Post> targetPost = postRepository.findById(postId);

        if (targetPost.isEmpty()) {
            System.out.println("Post doesn't exist");
            return;
        }

        Post post = targetPost.get();
        post.setUpvotes(post.getUpvotes() + 1);

        postRepository.save(post);
    }

    public List<Post> getUserPosts(int userId) {
        System.out.println("Getting user posts:" + userId);

        List<Post> posts = postRepository.findUserPosts(userId);

        return posts;
    }

    public List<Post> getPostsFromCategory(int categoryId) {
        System.out.println("Getting category posts: " + categoryId);

        List<Post> posts = postRepository.findPostsByCategoryId(categoryId);

        return posts;
    }

    public List<Post> getLatestPosts() {
        System.out.println("Getting latest posts");

        List<Post> posts = postRepository.findLatestPosts();

        return posts;
    }

    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
