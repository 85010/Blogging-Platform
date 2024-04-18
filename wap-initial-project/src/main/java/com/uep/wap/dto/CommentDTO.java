package com.uep.wap.dto;
import com.uep.wap.model.Post;

public class CommentDTO {

    private Integer id;
    private String content;
	private String author;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
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
