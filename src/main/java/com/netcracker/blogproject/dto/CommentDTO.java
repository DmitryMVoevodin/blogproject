package com.netcracker.blogproject.dto;

public class CommentDTO {

    private Integer commentId;
    private Integer commentArticleId;
    private Integer commentUserId;
    private String commentUserNickName;
    private String commentContent;

    public CommentDTO() {}

    public CommentDTO(Integer commentId, Integer commentArticleId, Integer commentUserId, String commentUserNickName, String commentContent) {
        this.commentId = commentId;
        this.commentArticleId = commentArticleId;
        this.commentUserId = commentUserId;
        this.commentContent = commentContent;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public String getCommentUserNickName() {
        return commentUserNickName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public void setCommentUserNickName(String commentUserNickName) {
        this.commentUserNickName = commentUserNickName;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

}
