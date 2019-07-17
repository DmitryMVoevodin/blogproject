package com.netcracker.blogproject.dto;

import io.swagger.annotations.ApiModelProperty;

public class ArticleDTO {

    @ApiModelProperty(notes = "Article's identification number")
    private Integer articleId;
    @ApiModelProperty(notes = "Topic that belongs to this article")
    private TopicDTO articleTopic;
    @ApiModelProperty(notes = "User that is the creator of this article")
    private UserDTO articleCreator;
    @ApiModelProperty(notes = "Rights (in the form like rwcrwcrwc) that belong to this article")
    private String articleRights;
    @ApiModelProperty(notes = "Title of this article")
    private String articleTitle;
    @ApiModelProperty(notes = "Annotation (brief description) of this article")
    private String articleComment;
    @ApiModelProperty(notes = "Text(content) of this article")
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
