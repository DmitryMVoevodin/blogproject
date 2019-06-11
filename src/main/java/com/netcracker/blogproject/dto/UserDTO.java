package com.netcracker.blogproject.dto;

public class UserDTO {

    private Integer userId;
    private String userLastName;
    private String userFirstName;
    private String userMiddleName;
    private String userMail;
    private String userPhone;
    private String userLogin;
    private String userPassword;
    private String userNickName;
    private Boolean userAdmin;
    private Boolean userStatusOfActivity;

    public UserDTO() {}

    public UserDTO(
            Integer userId,
            String userLastName, String userFirstName, String userMiddleName,
            String userMail, String userPhone,
            String userLogin, String userPassword, String userNickName,
            Boolean userAdmin, Boolean userStatusOfActivity
    ) {
        this.userId = userId;
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
}