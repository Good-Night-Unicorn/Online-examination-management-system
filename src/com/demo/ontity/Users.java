package com.demo.ontity;

public class Users {
    Integer userID;
    String userName;
    String password;
    String sex;
    String Email;

    public Users() {
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Users(Integer userID, String userName, String password, String sex, String email) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        Email = email;
    }
}
