package com.uep.wap.model;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @Column(name ="id")
    private int id;
    @Column(name ="content")
    private String content;
    @Column(name ="createdate")
    private long createdate;
    //nie ma dodanych wszystkich danych z UML, nie ma author,tags,comments, nie wiedzialem jak to dodac i czy wgl to sie dodaje czy przez ralacje to sie samo łączy

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_tag",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
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

    public Post(String content, Category category, long createdate, User author, List<Tag> tags) {
        this.content = content;
        this.category = category;
        this.createdate = createdate;
        this.author = author;
        this.tags = tags;
}
}

