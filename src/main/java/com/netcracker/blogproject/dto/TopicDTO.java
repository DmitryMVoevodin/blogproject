package com.netcracker.blogproject.dto;

import io.swagger.annotations.ApiModelProperty;

public class TopicDTO {

    @ApiModelProperty(notes = "Topic's identification number")
    private Integer topicId;
    @ApiModelProperty(notes = "User that is the creator of this topic")
    private UserDTO topicCreator;
    @ApiModelProperty(notes = "Title of this topic")
    private String topicTitle;
    @ApiModelProperty(notes = "Annotation (brief description) of this topic")
    private String topicComment;

    public TopicDTO() {}

    public TopicDTO(Integer topicId, UserDTO topicCreator, String topicTitle, String topicComment) {
        this.topicCreator = topicCreator;
        this.topicTitle = topicTitle;
        this.topicComment = topicComment;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public UserDTO getTopicCreator() {
        return topicCreator;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public String getTopicComment() {
        return topicComment;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public void setTopicCreator(UserDTO topicCreator) {
        this.topicCreator = topicCreator;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public void setTopicComment(String topicComment) {
        this.topicComment = topicComment;
    }

}
