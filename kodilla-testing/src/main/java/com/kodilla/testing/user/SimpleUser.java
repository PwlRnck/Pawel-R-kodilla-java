package com.kodilla.testing.user;

/**
 * Created by PR on 13.07.2017.
 */
public class SimpleUser {
    String username;
    String realName;
    public SimpleUser(String username, String realName) {
        this.username = username;
        this.realName = realName;
    }
    public String getUsername() {
        return username;
    }
    public String getRealName(){
        return realName;
    }
}
