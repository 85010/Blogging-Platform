package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @Column(name ="id")
    private int id;
    @Column(name ="content")
    private String content;

    @Column(name ="createdate")
    private String createdate;

	@ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    

    public Comment(){

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


	public String getCreatedate() {
		return createdate;
	}


	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

    public Comment(String content, String author, String createdate) {
        this.content = content;
        this.createdate = createdate;
    }
}



