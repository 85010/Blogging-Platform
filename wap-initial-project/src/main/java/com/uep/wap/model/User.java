package com.uep.wap.model;
import java.util.List;
import javax.persistence.*;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="username")
    private String username;
    @Column(name ="email")
    private String email;

    @Column(name ="role")
    private String role;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> comments;
    

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getComments() {
        return comments;
    }

    public void setComments(List<Post> comments) {
        this.comments = comments;
    }
    
    public User(String username, String email, String role){
        this.username = username;
        this.email = email;
        this.role = role;
    }
}


