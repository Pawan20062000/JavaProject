package com.example.TaskMASTER.service;
import com.example.TaskMASTER.model.Task;
import com.example.TaskMASTER.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getUserTasks(Long userId) {
        return taskRepository.findByAssignedToId(userId);
    }

    public List<Task> searchTasks(String keyword) {
        return taskRepository.findByTitleContainingOrDescriptionContaining(keyword, keyword);
    }

    public List<Task> filterByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}
