package com.netcracker.blogproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "settings")
public class SettingsForGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer settingsForGroupId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article settingsForGroupArticle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User settingsForGroupUser;

    @Column(name = "rights", nullable = false)
    private String settingsForGroupRights;

    public SettingsForGroup() {}

    public SettingsForGroup(Article settingsForGroupArticle, User settingsForGroupUser, String settingsForGroupRights) {
        this.settingsForGroupArticle = settingsForGroupArticle;
        this.settingsForGroupUser = settingsForGroupUser;
        this.settingsForGroupRights = settingsForGroupRights;
    }

    public Integer getSettingsForGroupId() {
        return settingsForGroupId;
    }

    public Article getSettingsForGroupArticle() {
        return settingsForGroupArticle;
    }

    public User getSettingsForGroupUser() {
        return settingsForGroupUser;
    }

    public String getSettingsForGroupRights() {
        return settingsForGroupRights;
    }

    public void setSettingsForGroupId(Integer settingsForGroupId) {
        this.settingsForGroupId = settingsForGroupId;
    }

    public void setSettingsForGroupArticle(Article settingsForGroupArticle) {
        this.settingsForGroupArticle = settingsForGroupArticle;
    }

    public void setSettingsForGroupUser(User settingsForGroupUser) {
        this.settingsForGroupUser = settingsForGroupUser;
    }

    public void setSettingsForGroupRights(String settingsForGroupRights) {
        this.settingsForGroupRights = settingsForGroupRights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SettingsForGroup)) return false;
        SettingsForGroup that = (SettingsForGroup) o;
        return Objects.equals(settingsForGroupArticle, that.settingsForGroupArticle) &&
                Objects.equals(settingsForGroupUser, that.settingsForGroupUser) &&
                Objects.equals(settingsForGroupRights, that.settingsForGroupRights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(settingsForGroupArticle, settingsForGroupUser, settingsForGroupRights);
    }

    @Override
    public String toString() {
        return "SettingsForGroup{" +
                "settingsForGroupArticle=" + settingsForGroupArticle +
                ", settingsForGroupUser=" + settingsForGroupUser +
                ", settingsForGroupRights='" + settingsForGroupRights + '\'' +
                '}';
    }

}
