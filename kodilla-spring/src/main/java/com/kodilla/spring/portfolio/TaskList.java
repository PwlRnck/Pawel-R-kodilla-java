package com.kodilla.spring.portfolio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void addTask(String newTask){
        tasks.add(newTask);
    }

}
