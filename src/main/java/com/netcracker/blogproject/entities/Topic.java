package com.netcracker.blogproject.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private Integer topicId;

    @Column(name = "ttitle", nullable = false)
    private String topicTitle;

    @Column(name = "tcomment", nullable = false)
    private String topicComment;

    @ManyToOne
    @JoinColumn(name = "tcreatorid")
    private User topicCreator;

    /*@OneToMany(targetEntity = Article.class, mappedBy = "articleTopic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Article> articles;*/

    public Topic() {}

    public Topic(String topicTitle, String topicComment, User topicCreator) {
        this.topicTitle = topicTitle;
        this.topicComment = topicComment;
        this.topicCreator = topicCreator;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public String getTopicComment() {
        return topicComment;
    }

    public User getTopicCreator() {
        return topicCreator;
    }

    /*public List<Article> getArticles() {
        return articles;
    }*/

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public void setTopicComment(String topicComment) {
        this.topicComment = topicComment;
    }

    public void setTopicCreator(User topicCreator) {
        this.topicCreator = topicCreator;
    }

    /*public void setArticles(List<Article> articles) {
        this.articles = articles;
    }*/

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof Topic)) return false;
        Topic obj1 = (Topic) obj;
        return ((this.topicId == obj1.topicId) &&
                (this.topicTitle.equals(obj1.topicTitle)) &&
                (this.topicComment.equals(obj1.topicComment)) &&
                (this.topicCreator.equals(obj1.topicCreator)));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + topicId;
        result = 31 * result + topicTitle.hashCode();
        result = 31 * result + topicComment.hashCode();
        result = 31 * result + topicCreator.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return ("Topic #" + topicId +
                "{title: " + topicTitle +
                "; comment: " + topicComment +
                "; author: " + topicCreator + "}"
        );
    }

}