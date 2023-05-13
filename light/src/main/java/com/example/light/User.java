package com.example.light;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public class User implements Serializable {
    private final Integer userId;
    private final String userName;

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    //    public User() {
//    }
//    public String getUserId() {
//        return userId;
//    }
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//    public String getUserName() {
//        return userName;
//    }
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId.toString() + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public User(String json) {
        User user = new Gson().fromJson(json, User.class);
        this.userId = user.userId;
        this.userName = user.userName;
    }
}