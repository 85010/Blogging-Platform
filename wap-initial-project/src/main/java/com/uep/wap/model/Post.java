package com.uep.wap.model;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @Column(name ="id")
    private int id;
    @Column(name ="title")
    private String title;
    @Column(name ="content")
    private String content;
    @Column(name ="createdate")
    private String createdate;
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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
    public Post(String title, String content, String category, String createdate) {
        this.title = title;
        this.content = content;
        this.createdate = createdate;
}
}

