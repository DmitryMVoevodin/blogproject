package com.netcracker.blogproject.dto;

public class TopicDTO {

    private Integer topicId;
    private UserDTO topicCreator;
    private String topicTitle;
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
