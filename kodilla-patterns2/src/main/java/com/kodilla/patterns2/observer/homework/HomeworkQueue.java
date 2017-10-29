package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HomeworkQueue implements Observable {
    private Observer observer;
    private final Deque<Task> tasks;
    private final String studentName;

    public HomeworkQueue(String studentName) {
        tasks = new ArrayDeque<>();
        this.studentName = studentName;
    }

    public void addTask(Task task) {
        tasks.offer(task);
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        observer.update(this);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observer = null;
    }

    public Observer getObserver() {
        return observer;
    }

    public Deque<Task> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }
}
