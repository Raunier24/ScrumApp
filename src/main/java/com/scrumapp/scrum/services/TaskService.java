package com.scrumapp.scrum.serivices;

import com.scrumapp.scrum.models.Task;
import com.scrumapp.scrum.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Obtener todas las tareas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Obtener una tarea por ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Crear o actualizar una tarea
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Eliminar una tarea por ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Obtener todas las tareas asignadas a un usuario
    public List<Task> getTasksByUserId(Long userId) {
       
