/*
package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialMedia.FacebookPublisher;
import com.kodilla.patterns.strategy.social.socialMedia.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.socialMedia.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class UserTestSuit {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        Millenials milUser = new Millenials("Millie");
        YGeneration yUser = new YGeneration("Yeti");
        ZGeneration zUser = new ZGeneration("Zibbie");
        //When
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        String output1 = null;
        String output2 = null;
        String output3 = null;

        try {
            milUser.sharePost();
            output1 = os.toString();
            os.flush();
            ps.flush();
            System.out.flush();

            yUser.sharePost();
            output2 = os.toString();
            os.flush();
            ps.flush();
            System.out.flush();

            zUser.sharePost();
            output3 = os.toString();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.setOut(originalOut);
        //Then
        Assert.assertEquals("Facebook" +  System.getProperty("line.separator"),output1);
        Assert.assertEquals("Twitter" +  System.getProperty("line.separator"),output2);
        Assert.assertEquals("Snapchat" +  System.getProperty("line.separator"),output3);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        Millenials milUser = new Millenials("Millie");
        YGeneration yUser = new YGeneration("Yeti");
        ZGeneration zUser = new ZGeneration("Zibbie");

        milUser.setFavoriteSocialMedium(new TwitterPublisher());
        yUser.setFavoriteSocialMedium(new SnapchatPublisher());
        zUser.setFavoriteSocialMedium(new FacebookPublisher());
        //When
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        String output1 = null;
        String output2 = null;
        String output3 = null;

        try {
            milUser.sharePost();
            output1 = os.toString();
            os.flush();
            ps.flush();
            System.out.flush();

            yUser.sharePost();
            output2 = os.toString();
            os.flush();
            ps.flush();
            System.out.flush();

            zUser.sharePost();
            output3 = os.toString();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.setOut(originalOut);
        //Then
        Assert.assertEquals("Twitter" +  System.getProperty("line.separator"),output1);
        Assert.assertEquals("Snapchat" +  System.getProperty("line.separator"),output2);
        Assert.assertEquals("Facebook" +  System.getProperty("line.separator"),output3);
    }
}
*/
package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialMedia.FacebookPublisher;
import com.kodilla.patterns.strategy.social.socialMedia.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.socialMedia.TwitterPublisher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class UserTestSuit {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private PrintStream originalOut;

    @Before
    public void setUp() throws Exception {
        originalOut = System.out;
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
    }

    @Test
    public void testDefaultSharingStrategies() throws Exception {
        //Given
        Millenials milUser = new Millenials("Millie");
        YGeneration yUser = new YGeneration("Yeti");
        ZGeneration zUser = new ZGeneration("Zibbie");
        //When
        OutputStream os;
        String output1;
        String output2;
        String output3;

        os = setOutputStream();
        milUser.sharePost();
        output1 = os.toString();

        os = setOutputStream();
        yUser.sharePost();
        output2 = os.toString();

        os = setOutputStream();
        zUser.sharePost();
        output3 = os.toString();

        //Then
        Assert.assertEquals("Facebook" + LINE_SEPARATOR, output1);
        Assert.assertEquals("Twitter" + LINE_SEPARATOR, output2);
        Assert.assertEquals("Snapchat" + LINE_SEPARATOR, output3);
    }

    private OutputStream setOutputStream() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        return os;
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        Millenials milUser = new Millenials("Millie");
        YGeneration yUser = new YGeneration("Yeti");
        ZGeneration zUser = new ZGeneration("Zibbie");

        milUser.setFavoriteSocialMedium(new TwitterPublisher());
        yUser.setFavoriteSocialMedium(new SnapchatPublisher());
        zUser.setFavoriteSocialMedium(new FacebookPublisher());
        //When
        OutputStream os;
        String output1;
        String output2;
        String output3;

        os = setOutputStream();
        milUser.sharePost();
        output1 = os.toString();

        os = setOutputStream();
        yUser.sharePost();
        output2 = os.toString();

        os = setOutputStream();
        zUser.sharePost();
        output3 = os.toString();

        //Then
        Assert.assertEquals("Twitter" + LINE_SEPARATOR, output1);
        Assert.assertEquals("Snapchat" + LINE_SEPARATOR, output2);
        Assert.assertEquals("Facebook" + LINE_SEPARATOR, output3);
    }
}