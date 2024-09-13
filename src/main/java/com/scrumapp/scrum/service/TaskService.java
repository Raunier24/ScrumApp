package com.scrumapp.scrum.service;

import com.scrumapp.models.Task;
import com.scrumapp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public ResponseEntity<Task> getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return ResponseEntity.ok(task);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public ResponseEntity<Task> updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            taskRepository.save(task);
        }
        return ResponseEntity.ok(task);
    }

    public ResponseEntity<Void> deleteTask(Long id) {
        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
