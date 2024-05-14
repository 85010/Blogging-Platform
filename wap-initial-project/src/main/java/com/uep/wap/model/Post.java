package com.uep.wap.model;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="content")
    private String content;
    @Column(name ="createdate")
    private long createdate;
    @Column(name = "upvotes")
    private int upvotes;
    @Column(name = "last_edited")
    private long lastEdited;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    

    public Post(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(long createdate) {
        this.createdate = createdate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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
    public long getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(long lastEdited) {
        this.lastEdited = lastEdited;
    }

    public Post(String content, Category category, long createdate, User author, List<Tag> tags, int upvotes, long lastEdited) {
        this.content = content;
        this.category = category;
        this.createdate = createdate;
        this.author = author;
        this.tags = tags;
        this.upvotes = upvotes;
        this.lastEdited = lastEdited;
}
}

