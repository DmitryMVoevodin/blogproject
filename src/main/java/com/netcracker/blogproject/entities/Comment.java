package com.netcracker.blogproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article commentArticle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User commentUser;

    @Column(name = "content", nullable = false)
    private String commentContent;

    public Comment() {}

    public Comment(Article commentArticle, User commentUser, String commentContent) {
        this.commentArticle = commentArticle;
        this.commentUser = commentUser;
        this.commentContent = commentContent;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public Article getCommentArticle() {
        return commentArticle;
    }

    public User getCommentUser() {
        return commentUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public void setCommentArticle(Article commentArticle) {
        this.commentArticle = commentArticle;
    }

    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment that = (Comment) o;
        return Objects.equals(commentArticle, that.commentArticle) &&
                Objects.equals(commentUser, that.commentUser) &&
                Objects.equals(commentContent, that.commentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentArticle, commentUser, commentContent);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentArticle=" + commentArticle +
                ", commentUser=" + commentUser +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }

}
