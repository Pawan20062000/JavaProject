package com.example.TaskMASTER.repository;
import com.example.TaskMASTER.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedToId(Long userId);
    List<Task> findByStatus(String status);
    List<Task> findByTitleContainingOrDescriptionContaining(String title, String desc);
}
