package com.niit.UserAuthentication.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel
{
    @Id
    private String emailId;
    private String password;

    public UserModel()
    {

    }

    public UserModel(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + emailId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
