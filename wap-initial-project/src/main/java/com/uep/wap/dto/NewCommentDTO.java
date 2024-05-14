package com.uep.wap.dto;

public class NewCommentDTO {

    private String content;

    private int authorId;

    private int parentPostId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getParentPostId() {
        return parentPostId;
    }

    public void setParentPost(int parentPostId) {
        this.parentPostId = parentPostId;
    }
}
