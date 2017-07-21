package com.kodilla.testing.forum.statistics;

import junitparams.JUnitParamsRunner;
import junitparams.custom.combined.CombinedParameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by PR on 21.07.2017.
 */
@RunWith(JUnitParamsRunner.class)
public class ForumStatisticsTestSuite {

    @Test
    @CombinedParameters({"0|999|1001","0|1000","0|100"})
    public void testCalculateAdvStatistics(int commentsNumber, int postsNumber, int usersNumber ){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);
        when(statisticsMock.postsCount()).thenReturn(postsNumber);

        List<String> mockedList = (List<String>)mock(List.class);
        when(statisticsMock.usersNames()).thenReturn(mockedList);
        when(mockedList.size()).thenReturn(usersNumber);
        ForumStatistics forumStatistics = new ForumStatistics();
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Double a = null;Double b = null; Double c = null;
        if(usersNumber==0){a = null;}else{a = (double)postsNumber/usersNumber;}
        if(usersNumber==0){b = null;}else{b = (double)commentsNumber/usersNumber;}
        if(postsNumber==0){c = null;}else{c = (double)commentsNumber/postsNumber;}

        Assert.assertEquals(a,forumStatistics.getPostsPerUser());
        Assert.assertEquals(b,forumStatistics.getCommentsPerUser());
        Assert.assertEquals(c,forumStatistics.getCommentsPerPost());
    }
}