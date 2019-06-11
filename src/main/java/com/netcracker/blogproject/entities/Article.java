package com.netcracker.blogproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer articleId;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic articleTopic;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User articleCreator;

    @Column(name = "rights", nullable = false)
    private String articleRights;

    @Column(name = "title", nullable = false)
    private String articleTitle;

    @Column(name = "comment", nullable = false)
    private String articleComment;

    @Column(name = "content", nullable = false)
    private String articleContent;

    public Article() {}

    public Article(Topic articleTopic, User articleCreator, String articleRights, String articleTitle, String articleComment, String articleContent) {
        this.articleTopic = articleTopic;
        this.articleCreator = articleCreator;
        this.articleRights = articleRights;
        this.articleTitle = articleTitle;
        this.articleComment = articleComment;
        this.articleContent = articleContent;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public Topic getArticleTopic() {
        return articleTopic;
    }

    public User getArticleCreator() {
        return articleCreator;
    }

    public String getArticleRights() {
        return articleRights;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleComment() {
        return articleComment;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public void setArticleTopic(Topic articleTopic) {
        this.articleTopic = articleTopic;
    }

    public void setArticleCreator(User articleCreator) {
        this.articleCreator = articleCreator;
    }

    public void setArticleRights(String articleRights) {
        this.articleRights = articleRights;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setArticleComment(String articleComment) {
        this.articleComment = articleComment;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(articleId, article.articleId) &&
                Objects.equals(articleTopic, article.articleTopic) &&
                Objects.equals(articleCreator, article.articleCreator) &&
                Objects.equals(articleRights, article.articleRights) &&
                Objects.equals(articleTitle, article.articleTitle) &&
                Objects.equals(articleComment, article.articleComment) &&
                Objects.equals(articleContent, article.articleContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, articleTopic, articleCreator,
                articleRights, articleTitle, articleComment, articleContent);
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTopic=" + articleTopic +
                ", articleCreator=" + articleCreator +
                ", articleRights='" + articleRights + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleComment='" + articleComment + '\'' +
                ", articleContent='" + articleContent + '\'' +
                '}';
    }

}