package com.uep.wap.dto;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.uep.wap.model.Post;

public class CommentDTO {

    private Integer id;
    private String content;
	private User author;
	private String createdate;
	private Post parentPost;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Post getParentPost(){
		return parentPost;
	}

	public void setParentPost(Post parentPost){
		this.parentPost = parentPost;
	}
}
