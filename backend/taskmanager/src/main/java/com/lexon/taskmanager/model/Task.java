package com.lexon.taskmanager.model;

public class Task {
    private int id;          // id for task
    private String title;       // name for task
    private boolean done;       // complete/incomplete for task


    public Task(int id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }


    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getDone() {
        return done;
    }


    //Setters
    public void setId(int newId) {
        id = newId;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public void setDone(boolean newDone) {
        done = newDone;
    }
}
