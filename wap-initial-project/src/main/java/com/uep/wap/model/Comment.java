package com.uep.wap.model;
import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="content")
    private String content;

    @Column(name ="createdate")
    private long createdate;

	@ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "parent_post_id")
    private Post parentPost;

    
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
		return createdate;
	}


	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}

	public Post getParentPost(){
		return parentPost;
	}

	public void setParentPost(Post parentPost){
		this.parentPost = parentPost;
	}

	public Comment() {
	}

    public Comment(String content, User author, long createdate, Post parentPost) {
		this.content = content;
		this.author = author;
		this.createdate = createdate;
		this.parentPost = parentPost;
	}
	
}



