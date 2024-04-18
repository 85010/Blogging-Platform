package com.uep.wap.dto;

import java.util.List;

import com.uep.wap.model.Post;

public class TagDTO {

    private Integer id;
    private String name;
	private List<Post> posts;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts(){
		return posts;
	}

	public void setPosts(List<Post> posts){
		this.posts = posts;
	}

}
