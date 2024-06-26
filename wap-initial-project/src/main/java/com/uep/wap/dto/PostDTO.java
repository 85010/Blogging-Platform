package com.uep.wap.dto;

import java.util.List;
import com.uep.wap.model.Category;
import com.uep.wap.model.Comment;
import com.uep.wap.model.Tag;
import com.uep.wap.model.User;

public class PostDTO {

    private Integer id;
    private String title;
    private String content;
    private User author;
    private List<Tag> tags;
    private Category category;
    private long createDate;
    private List<Comment> comments;
    private int upvotes;
    private long lastEdited;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    
    public Integer getAuthorId() {
        return author != null ? author.getId() : null;
    }

    public Integer getCategoryId() {
        return category != null ? category.getId() : null;
    }
}
