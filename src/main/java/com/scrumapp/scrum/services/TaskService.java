package com.scrumapp.scrum.services;


import com.scrumapp.scrum.models.Task;
import com.scrumapp.scrum.repositories.ITaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final ITaskRepository taskRepository;

    // Constructor-based dependency injection
    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll ();
    }

    // Get a task by ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById (id);
    }

    // Create or update a task
    public Task saveTask(Task task) {
        return taskRepository.save (task);
    }

    // Delete a task by ID
    public void deleteTask(Long id) {
        taskRepository.deleteById (id);
    }

    // Get tasks assigned to a specific user
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserIdUser (userId);
    }

    // Get tasks associated with a specific project
    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId (projectId);
    }
}