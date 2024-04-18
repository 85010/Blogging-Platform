package com.uep.wap.model;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
    
    public Tag(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    public Tag(String name){
        this.name = name;
    }
    
    public Tag(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }
}


