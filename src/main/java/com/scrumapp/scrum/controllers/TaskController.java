package com.scrumapp.scrum.controllers;

import com.scrumapp.scrum.models.Task;
import com.scrumapp.scrum.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping(path = "/task")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }


    @GetMapping (path = "/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping(path = "/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.ok(createdTask);
    }


    @PutMapping(path = "/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Optional<Task> existingTask = taskService.getTaskById(id);
        if (existingTask.isPresent()) {
            updatedTask.setId(id); // Set the ID to ensure it's an update
            Task savedTask = taskService.saveTask(updatedTask);
            return ResponseEntity.ok(savedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(path = "/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get tasks assigned to a specific user
    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    // Get tasks associated with a specific project
    @GetMapping("/project/{projectId}")
    public List<Task> getTasksByProjectId(@PathVariable Long projectId) {
        return taskService.getTasksByProjectId(projectId);
    }
}
