package com.uep.wap.dto;

import com.uep.wap.model.Tag;

import java.util.List;

public class NewPostDTO {

    private String content;

    private int upvotes;

    private long createdate;

    private long lastEdited;

    private int authorId;

    private int categoryId;

    private List<Tag> tags;

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

    public long getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(long lastEdited) {
        this.lastEdited = lastEdited;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
}