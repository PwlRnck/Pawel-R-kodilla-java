package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(HomeworkQueue homeworkQueue) {
        System.out.println(name + ": New homework from student " + homeworkQueue.getStudentName() + "\n" +
                            "         module: " + homeworkQueue.getTasks().peekLast().getModule() + ",\n" +
                            "         task title: " + homeworkQueue.getTasks().peekLast().getTitle() + "\n" +
                            "         (total: " + homeworkQueue.getTasks().size() + " tasks)" + "\n");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
