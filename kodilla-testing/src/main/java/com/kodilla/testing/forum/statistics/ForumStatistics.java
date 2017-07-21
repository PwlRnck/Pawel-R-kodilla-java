package com.kodilla.testing.forum.statistics;

/**
 * Created by PR on 21.07.2017.
 */
public class ForumStatistics {

    private int usersNumber;
    private int postsNumber;
    private int commentsNumber;
    protected Double postsPerUser;
    protected Double commentsPerUser;
    protected Double commentsPerPost;

    public int getUsersNumber() {
        return usersNumber;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public Double getPostsPerUser() {
        return postsPerUser;
    }

    public Double getCommentsPerUser() {
        return commentsPerUser;
    }

    public Double getCommentsPerPost() {
        return commentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics){
        usersNumber = (statistics.usersNames()).size();
        postsNumber = statistics.postsCount();
        commentsNumber = statistics.commentsCount();

        if(usersNumber>0){
            commentsPerUser = (double)commentsNumber/usersNumber;
            postsPerUser = (double)postsNumber/usersNumber;
        }
        if(postsNumber>0){
            commentsPerPost = (double)commentsNumber/postsNumber;
        }
    }

    public void showStatistics(){
        System.out.println("Users number: " + usersNumber);
        System.out.println("Posts number: " + postsNumber);
        System.out.println("Comments number: " + commentsNumber);
        System.out.println("Posts per users: " + postsPerUser);
        System.out.println("Comments per users: " + commentsPerUser);
        System.out.println("Comments per post: " + commentsPerPost);
    }

}
