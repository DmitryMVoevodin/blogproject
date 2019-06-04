package com.netcracker.blogproject.entities;

import com.netcracker.blogproject.entities.additional.SettingsComments;
import com.netcracker.blogproject.entities.additional.SettingsVisibility;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Integer articleId;

    @Column(name = "atitle", nullable = false)
    private String articleTitle;

    @Column(name = "acomment", nullable = false)
    private String articleComment;

    @Column(name = "acontent", nullable = false)
    private String articleContent;

    @ManyToOne
    @JoinColumn(name = "atopicid")
    private Topic articleTopic;

    @Column(name = "asetvis", nullable = false)
    private String articleSettingsVisible;

    @Column(name = "asetcom", nullable = false)
    private String articleSettingsComments;

    @ManyToOne
    @JoinColumn(name = "acreatorid")
    private User articleCreator;

    public Article() {}

    public Article(String articleTitle, String articleComment, String articleContent, Topic articleTopic, String articleSettingsVisible, String articleSettingsComments, User articleCreator) {
        this.articleTitle = articleTitle;
        this.articleComment = articleComment;
        this.articleContent = articleContent;
        this.articleTopic = articleTopic;
        this.articleSettingsVisible = articleSettingsVisible;
        this.articleSettingsComments = articleSettingsComments;
        this.articleCreator = articleCreator;
    }

    public Article(String articleTitle, String articleComment, String articleContent, Topic articleTopic, SettingsVisibility articleSettingsVisible, SettingsComments articleSettingsComments, User articleCreator) {
        this(articleTitle, articleComment, articleContent, articleTopic, "", "", articleCreator);
        this.setArticleSettingsVisible(articleSettingsVisible);
        this.setArticleSettingsComments(articleSettingsComments);
    }

    public Integer getArticleId() {
        return articleId;
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

    public Topic getArticleTopic() {
        return articleTopic;
    }

    public String getArticleSettingsVisible() {
        return articleSettingsVisible;
    }

    public String getArticleSettingsComments() {
        return articleSettingsComments;
    }

    public User getArticleCreator() {
        return articleCreator;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    public void setArticleTopic(Topic articleTopic) {
        this.articleTopic = articleTopic;
    }

    public void setArticleSettingsVisible(SettingsVisibility settingsVisibility) {
        switch (settingsVisibility) {
            case ONLY_FOR_ME:
                this.articleSettingsVisible = "Only for me";
                break;
            case FOR_SOME_USERS:
                this.articleSettingsVisible = "For some users";
                break;
            case FOR_ALL_USERS:
                this.articleSettingsVisible = "For all users";
            default:
                this.articleSettingsVisible = "Only for me";
                break;
        }
    }

    public void setArticleSettingsVisible(String articleSettingsVisible) {
        this.articleSettingsVisible = articleSettingsVisible;
    }

    public void setArticleSettingsComments(SettingsComments settingsComments) {
        switch (settingsComments) {
            case ONLY_FOR_ME:
                this.articleSettingsComments = "Only for me";
                break;
            case FOR_SOME_USERS:
                this.articleSettingsComments = "For some users";
                break;
            case FOR_ALL_USERS:
                this.articleSettingsComments = "For all users";
            default:
                this.articleSettingsComments = "Only for me";
                break;
        }
    }

    public void setArticleSettingsComments(String articleSettingsComments) {
        this.articleSettingsComments = articleSettingsComments;
    }

    public void setArticleCreator(User articleCreator) {
        this.articleCreator = articleCreator;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof Article)) return false;
        Article obj1 = (Article) obj;
        return ((this.articleId == obj1.articleId) &&
                (this.articleTitle.equals(obj1.articleTitle)) &&
                (this.articleComment.equals(obj1.articleComment)) &&
                (this.articleContent.equals(obj1.articleContent)) &&
                (this.articleTopic.equals(obj1.articleTopic)) &&
                (this.articleSettingsVisible.equals(obj1.articleSettingsVisible)) &&
                (this.articleSettingsComments.equals(obj1.articleSettingsComments)) &&
                (this.articleCreator.equals(obj1.articleCreator)));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + articleId;
        result = 31 * result + articleTitle.hashCode();
        result = 31 * result + articleComment.hashCode();
        result = 31 * result + articleContent.hashCode();
        result = 31 * result + articleTopic.hashCode();
        result = 31 * result + articleSettingsVisible.hashCode();
        result = 31 * result + articleSettingsComments.hashCode();
        result = 31 * result + articleCreator.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return ("\n------------------------------------------------------------------------" +
                "\nArticle #" + articleId +
                "\n------------------------------------------------------------------------" +
                "\nAuthor: " + articleCreator +
                "\nTitle: " + articleTitle +
                ";\nComment: " + articleComment +
                ";\nContent:\n" + articleContent +
                ";\nBelongs to the " + articleTopic +
                ";\nSettings of visibility: " + articleSettingsVisible +
                ";\nSettings of comments: " + articleSettingsComments
        );
    }

}