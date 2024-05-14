package com.uep.wap.model;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    public Category(){

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
    public void Tag(String name){
        this.name = name;
    }
    
    public Category(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }
}


