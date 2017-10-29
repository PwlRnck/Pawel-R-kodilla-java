package com.kodilla.patterns2.observer.homework;

public class Task {
    private String module;
    private String title;

    public Task(String module, String title) {
        this.module = module;
        this.title = title;
    }

    public String getModule() {
        return module;
    }

    public String getTitle() {
        return title;
    }
}
