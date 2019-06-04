package com.netcracker.blogproject.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Integer userId;

    @Column(name = "ulname", nullable = false)
    private String userLastName;

    @Column(name = "ufname", nullable = false)
    private String userFirstName;

    @Column(name = "umname", nullable = false)
    private String userMiddleName;

    @Column(name = "umail", nullable = false)
    private String userMail;

    @Column(name = "uphone", nullable = false)
    private String userPhone;

    @Column(name = "ulogin", nullable = false)
    private String userLogin;

    @Column(name = "upassword", nullable = false)
    private String userPassword;

    @Column(name = "unickname", nullable = false)
    private String userNickName;

    @Column(name = "uadmin", nullable = false)
    private Boolean userAdmin;

    /*@OneToMany(targetEntity = Topic.class, mappedBy = "topicCreator", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topic> topics;

    @OneToMany(targetEntity = Article.class, mappedBy = "articleCreator", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Article> articles;*/

    public User() {}

    public User(String userLastName, String userFirstName, String userMiddleName, String userMail, String userPhone, String userLogin, String userPassword, String userNickName, Boolean userAdmin) {
        this.userLastName = userLastName;
        this.userFirstName = userFirstName;
        this.userMiddleName = userMiddleName;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userNickName = userNickName;
        this.userAdmin = userAdmin;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public Boolean getUserAdmin() {
        return userAdmin;
    }

    /*public List<Topic> getTopics() {
        return topics;
    }

    public List<Article> getArticles() {
        return articles;
    }*/

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public void setUserAdmin(Boolean userAdmin) {
        this.userAdmin = userAdmin;
    }

    /*public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }*/

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof User)) return false;
        User obj1 = (User) obj;
        return ((this.userId == obj1.userId) &&
                (this.userLastName.equals(obj1.userLastName)) &&
                (this.userFirstName.equals(obj1.userFirstName)) &&
                (this.userMiddleName.equals(obj1.userMiddleName)) &&
                (this.userMail.equals(obj1.userMail)) &&
                (this.userPhone.equals(obj1.userPhone)) &&
                (this.userLogin.equals(obj1.userLogin)) &&
                (this.userPassword.equals(obj1.userPassword)) &&
                (this.userNickName.equals(obj1.userNickName)) &&
                (this.userAdmin.equals(obj1.userAdmin)));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + userId;
        result = 31 * result + userLastName.hashCode();
        result = 31 * result + userFirstName.hashCode();
        result = 31 * result + userMiddleName.hashCode();
        result = 31 * result + userMail.hashCode();
        result = 31 * result + userPhone.hashCode();
        result = 31 * result + userLogin.hashCode();
        result = 31 * result + userPassword.hashCode();
        result = 31 * result + userNickName.hashCode();
        result = 31 * result + (userAdmin ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return ("User #" + userId +
                " [" + userLastName + " " + userFirstName + " " + userMiddleName +
                "; mail: " + userMail + "; phone: " + userPhone +
                "; login: " + userLogin + "; password: " + userPassword +
                "; nickname: " + userNickName + "; admin: " + userAdmin + "]");
    }


}