package com.kodilla.patterns.strategy.social;

public class User {
    private String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public void setFavoriteSocialMedium(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public void sharePost() {
        socialPublisher.share();
    }
}