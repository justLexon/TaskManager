package com.lexon.taskmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Task {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;          // id for task
    private String title;       // name for task
    private boolean done;       // complete/incomplete for task


    public Task() {}

    public Task(Integer id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }


    //Getters
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getDone() {
        return done;
    }


    //Setters
    public void setId(Integer newId) {
        this.id = newId;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setDone(boolean newDone) {
        this.done = newDone;
    }
}
