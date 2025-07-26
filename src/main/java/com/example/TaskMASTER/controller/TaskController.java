package com.example.TaskMASTER.controller;

import com.example.TaskMASTER.model.*;
import com.example.TaskMASTER.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getUserTasks(@PathVariable Long userId) {
        return taskService.getUserTasks(userId);
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String query) {
        return taskService.searchTasks(query);
    }

    @GetMapping("/filter")
    public List<Task> filterTasks(@RequestParam String status) {
        return taskService.filterByStatus(status);
    }
}
