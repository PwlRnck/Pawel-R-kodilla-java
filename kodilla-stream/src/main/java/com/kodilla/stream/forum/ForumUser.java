package com.kodilla.stream.forum;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by PR on 24.07.2017.
 */
public class ForumUser {
    private final  int id;
    private final String userName;
    private final char userSex;
    private final LocalDate dateOfBirth;
    private final  int postsCount;

    public ForumUser(int id, String userName, char userSex, LocalDate dateOfBirth, int postsCount) {
        this.id = id;
        this.userName = userName;
        this.userSex = userSex;
        this.dateOfBirth = dateOfBirth;
        this.postsCount = postsCount;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getAge(){
        return Period.between(dateOfBirth,LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", dateOfBirth=" + dateOfBirth +
                ", postsCount=" + postsCount +
                '}';
    }
}
