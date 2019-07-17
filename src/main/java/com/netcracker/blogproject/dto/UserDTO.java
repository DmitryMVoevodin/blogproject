package com.netcracker.blogproject.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserDTO {

    @ApiModelProperty(notes = "User's identification number")
    private Integer userId;
    @ApiModelProperty(notes = "Last name of this user")
    private String userLastName;
    @ApiModelProperty(notes = "First name of this user")
    private String userFirstName;
    @ApiModelProperty(notes = "Middle name of this user")
    private String userMiddleName;
    @ApiModelProperty(notes = "Email of this user")
    private String userMail;
    @ApiModelProperty(notes = "Phone number of this user")
    private String userPhone;
    @ApiModelProperty(notes = "Login of this user")
    private String userLogin;
    @ApiModelProperty(notes = "Password of this user")
    private String userPassword;
    @ApiModelProperty(notes = "Nickname of this user")
    private String userNickName;
    @ApiModelProperty(notes = "Does this user have the admin-status?")
    private Boolean userAdmin;
    @ApiModelProperty(notes = "Additional information for further project development")
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