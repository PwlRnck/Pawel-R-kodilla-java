package com.kodilla.stream.forum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by PR on 24.07.2017.
 */
public class Forum {
    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum(int usersNumber){
    Random randGen = new Random();
        for(int i=0;i<usersNumber;i++){
            //generate name
            String userName = Character.toString((char)(randGen.nextInt(26)+65));
            for(int j=0;j<5;j++){
                userName = userName + Character.toString((char)(randGen.nextInt(26)+97));
            }
            userName = userName + " " + Character.toString((char)(randGen.nextInt(26)+65));
            for(int j=0;j<5;j++){
                userName = userName + Character.toString((char)(randGen.nextInt(26)+97));
            }

            //determine sex
            char userSex;
            int sex = randGen.nextInt(2);
            if(sex == 0)
                userSex = 'M';
            else
                userSex = 'F';

            //determine date of birth
            int year = randGen.nextInt(70)+1930;
            int month = randGen.nextInt(12)+1;
            int[] shortMonths = {4,6,9,11};
            int day;
            if(Arrays.asList(shortMonths).contains(month))
                day = randGen.nextInt(30)+1;
            else if(month == 2)
                day = randGen.nextInt(28)+1;
            else
                day = randGen.nextInt(31)+1;

            LocalDate dateOfBirth = LocalDate.of(year,month,day);

            //postsCount
            int postsCount = randGen.nextInt(10);

            usersList.add(new ForumUser(i,userName,userSex,dateOfBirth,postsCount));
        }
    }

    public List<ForumUser> getUsersList(){
        return new ArrayList<>(usersList);
    }
}
