package com.scrumapp.scrum.services;


import com.scrumapp.scrum.models.Task;
import com.scrumapp.scrum.repositories.ITaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final ITaskRepository taskRepository;


    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll ();
    }


    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById (id);
    }


    public Task saveTask(Task task) {
        return taskRepository.save (task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById (id);
    }


    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserIdUser (userId);
    }

    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectIdProject(projectId);
    }
}