package com.lexon.taskmanager.controller;

import com.lexon.taskmanager.model.*;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")
public class Controller {

    //Fields
     private List<Task> tasks = new ArrayList<>(
        List.of( 
            new Task(1, "Write", false),
            new Task(2, "Read", false),
            new Task(3, "Workout", true)
            )
        );


    //Gets
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasks;
    }
    

    //Posts
    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task newTask) {
        tasks.add(newTask);
        return newTask;
    }
    

    //Deletes
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int newId) {
        tasks.removeIf(task -> task.getId() == newId);
        return "Task " + newId + " Deleted";
    }
}
