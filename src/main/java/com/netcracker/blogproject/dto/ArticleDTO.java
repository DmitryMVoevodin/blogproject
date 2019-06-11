package com.netcracker.blogproject.dto;

public class ArticleDTO {

    private Integer articleId;
    private TopicDTO articleTopic;
    private UserDTO articleCreator;
    private String articleRights;
    private String articleTitle;
    private String articleComment;
    private String articleContent;

    public ArticleDTO() {}

    public ArticleDTO(Integer articleId, TopicDTO articleTopic, UserDTO articleCreator,
                      String articleRights, String articleTitle, String articleComment, String articleContent) {
        this.articleId = articleId;
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

    public TopicDTO getArticleTopic() {
        return articleTopic;
    }

    public UserDTO getArticleCreator() {
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

    public void setArticleTopic(TopicDTO articleTopic) {
        this.articleTopic = articleTopic;
    }

    public void setArticleCreator(UserDTO articleCreator) {
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

}
