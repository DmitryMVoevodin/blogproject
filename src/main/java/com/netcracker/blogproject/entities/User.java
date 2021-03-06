package com.netcracker.blogproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer userId;

    @Column(name = "last_name", nullable = false)
    private String userLastName;

    @Column(name = "first_name", nullable = false)
    private String userFirstName;

    @Column(name = "middle_name", nullable = false)
    private String userMiddleName;

    @Column(name = "mail", nullable = false)
    private String userMail;

    @Column(name = "phone", nullable = false)
    private String userPhone;

    @Column(name = "login", nullable = false)
    private String userLogin;

    @Column(name = "password", nullable = false)
    private String userPassword;

    @Column(name = "nickname", nullable = false)
    private String userNickName;

    @Column(name = "admin", nullable = false)
    private Boolean userAdmin;

    @Column(name = "status_of_activity", nullable = false)
    private Boolean userStatusOfActivity;

    public User() {}

    public User(
            String userLastName, String userFirstName, String userMiddleName,
            String userMail, String userPhone,
            String userLogin, String userPassword, String userNickName,
            Boolean userAdmin, Boolean userStatusOfActivity
    ) {
        this.userLastName = userLastName;
        this.userFirstName = userFirstName;
        this.userMiddleName = userMiddleName;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userNickName = userNickName;
        this.userAdmin = userAdmin;
        this.userStatusOfActivity = userStatusOfActivity;
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

    public Boolean getUserStatusOfActivity() {
        return userStatusOfActivity;
    }

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

    public void setUserStatusOfActivity(Boolean userStatusOfActivity) {
        this.userStatusOfActivity = userStatusOfActivity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userMiddleName, user.userMiddleName) &&
                Objects.equals(userMail, user.userMail) &&
                Objects.equals(userPhone, user.userPhone) &&
                Objects.equals(userLogin, user.userLogin) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userNickName, user.userNickName) &&
                Objects.equals(userAdmin, user.userAdmin) &&
                Objects.equals(userStatusOfActivity, user.userStatusOfActivity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                userId,
                userLastName, userFirstName, userMiddleName,
                userMail, userPhone,
                userLogin, userPassword, userNickName,
                userAdmin, userStatusOfActivity);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userLastName='" + userLastName + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userMiddleName='" + userMiddleName + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userAdmin=" + userAdmin +
                ", userStatusOfActivity=" + userStatusOfActivity +
                '}';
    }

}