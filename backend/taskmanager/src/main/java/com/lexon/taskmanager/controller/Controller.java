package com.lexon.taskmanager.controller;

import com.lexon.taskmanager.model.*;
import com.lexon.taskmanager.service.TaskRepository;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // allow Next.js frontend
public class Controller {

    //Fields
    @Autowired
    private TaskRepository taskRepository;

    // private List<Task> tasks = new ArrayList<>(
    //     List.of( 
    //         new Task(1, "Write", false),
    //         new Task(2, "Read", false),
    //         new Task(3, "Workout", true)
    //         )
    //     );


    //Gets
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
    

    //Posts
    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task newTask) {
        // tasks.add(newTask);
        // return newTask;
        return taskRepository.save(newTask);
    }
    

    //Deletes
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Integer id) {
        // tasks.removeIf(task -> task.getId() == id);
        // return "Task " + id + " Deleted";
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()) {
            taskRepository.deleteById(id);
            return "Task " + id + " deleted";
        } else {
            return "Task " + id + " not found";
        }
    }
}
