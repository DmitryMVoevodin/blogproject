package com.netcracker.blogproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "queue_of_topics")
public class TopicAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer topicId;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User topicCreator;

    @Column(name = "title", nullable = false)
    private String topicTitle;

    @Column(name = "comment", nullable = false)
    private String topicComment;

    public TopicAdmin() {}

    public TopicAdmin(User topicCreator, String topicTitle, String topicComment) {
        this.topicCreator = topicCreator;
        this.topicTitle = topicTitle;
        this.topicComment = topicComment;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public User getTopicCreator() {
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

    public void setTopicCreator(User topicCreator) {
        this.topicCreator = topicCreator;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public void setTopicComment(String topicComment) {
        this.topicComment = topicComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopicAdmin)) return false;
        TopicAdmin topic = (TopicAdmin) o;
        return Objects.equals(topicId, topic.topicId) &&
                Objects.equals(topicCreator, topic.topicCreator) &&
                Objects.equals(topicTitle, topic.topicTitle) &&
                Objects.equals(topicComment, topic.topicComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicId, topicCreator, topicTitle, topicComment);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicCreator=" + topicCreator +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicComment='" + topicComment + '\'' +
                '}';
    }

}
