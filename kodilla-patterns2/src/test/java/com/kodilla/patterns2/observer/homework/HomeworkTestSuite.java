package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.ForumTopic;
import com.kodilla.patterns2.observer.forum.ForumUser;
import com.kodilla.patterns2.observer.forum.JavaHelpForumTopic;
import com.kodilla.patterns2.observer.forum.JavaToolsForumTopic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {
    @Test
    public void testUpdate() {
        //Given
        HomeworkQueue homeworkQueue1 = new HomeworkQueue("Student A");
        HomeworkQueue homeworkQueue2 = new HomeworkQueue("Student B");
        HomeworkQueue homeworkQueue3 = new HomeworkQueue("Student C");
        HomeworkQueue homeworkQueue4 = new HomeworkQueue("Student D");

        Mentor mentor1 = new Mentor("Mentor A");
        Mentor mentor2 = new Mentor("Mentor B");

        homeworkQueue1.registerObserver(mentor1);
        homeworkQueue2.registerObserver(mentor2);
        homeworkQueue3.registerObserver(mentor1);
        homeworkQueue4.registerObserver(mentor2);

        Task task1 = new Task("1.1", "Java basics");
        Task task2 = new Task("1.2", "Java intermediate");
        Task task3 = new Task("2.1", "Java - from zero to hero");
        Task task4 = new Task("3", "Java - Spring");
        Task task5 = new Task("4", "Java - Hibernate");

        //When
        homeworkQueue1.addTask(task1);
        homeworkQueue2.addTask(task1);
        homeworkQueue3.addTask(task1);
        homeworkQueue4.addTask(task1);
        homeworkQueue1.addTask(task2);
        homeworkQueue2.addTask(task2);
        homeworkQueue3.addTask(task2);
        homeworkQueue1.addTask(task3);
        homeworkQueue2.addTask(task3);
        homeworkQueue3.addTask(task3);
        homeworkQueue1.addTask(task4);
        homeworkQueue2.addTask(task4);
        homeworkQueue1.addTask(task5);
        //Then
        assertEquals(8, mentor1.getUpdateCount());
        assertEquals(5, mentor2.getUpdateCount());
    }

}
