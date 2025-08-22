package com.lexon.taskmanager.service;

import com.lexon.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    // You don’t need to write anything here for basic CRUD
}