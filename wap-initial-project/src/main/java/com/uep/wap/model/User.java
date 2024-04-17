package com.uep.wap.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name ="id")
    private int id;
    @Column(name ="username")
    private String username;
    @Column(name ="email")
    private String email;

    @Column(name ="role")
    private String role;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Comment> comments;
    

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)



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
    
    public User(String username, String email, String role){
        this.username = username;
        this.email = email;
        this.role = role;
    }
}


