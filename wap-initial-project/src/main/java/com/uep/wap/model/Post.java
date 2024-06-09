package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    
    private int id;
    @Column(name = "content")
    private String content;

    @Column(name = "upvotes")
    private int upvotes;

    @Column(name = "create_date")
    private long createDate;

    @Column(name = "last_edited")
    private long lastEdited;

    @JsonIgnoreProperties({"posts", "comments"})
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @JsonIgnoreProperties("posts")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_tags", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @JsonIgnoreProperties({"parentPost", "author"})
    @OneToMany(mappedBy = "parentPost", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Post() {
    }

    public Post(int id) {
        this.id = id;
    }

    public Post(String content, User author, long createDate, long lastEdited, Category category, List<Tag> tags, int upvotes) {
        this.content = content;
        this.createDate = createDate;
        this.lastEdited = lastEdited;
        this.tags = tags;
        this.upvotes = upvotes;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedate() {
        return createDate;
    }

    public void setCreatedate(long createdate) {
        this.createDate = createdate;
    }

    public long getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(long lastEdited) {
        this.lastEdited = lastEdited;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}


