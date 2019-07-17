package com.netcracker.blogproject.dto;

import io.swagger.annotations.ApiModelProperty;

public class CommentDTO {

    @ApiModelProperty(notes = "Comment's identification number")
    private Integer commentId;
    @ApiModelProperty(notes = "Article's identification number (the comment was added to this article)")
    private Integer commentArticleId;
    @ApiModelProperty(notes = "Commentator's identification number (the comment was added by this user)")
    private Integer commentUserId;
    @ApiModelProperty(notes = "Nickname of the author of this comment")
    private String commentUserNickName;
    @ApiModelProperty(notes = "Text (the content) of this comment")
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
