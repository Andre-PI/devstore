package com.avorio.devstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
    @Id
    private int user_ID;
    @Column(name="username")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="role")
    private String role;

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public User(){

    }
    public int getId() {
        return this.user_ID;
    }
    public void setId(int user_ID) {
        this.user_ID = user_ID;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(user_ID);
        builder.append(", userName=");
        builder.append(getUserName());
        builder.append(", password=");
        builder.append(getPassword());
        builder.append(", email=");
        builder.append(getEmail());
        builder.append("]");
        return builder.toString();
    }
    
}
