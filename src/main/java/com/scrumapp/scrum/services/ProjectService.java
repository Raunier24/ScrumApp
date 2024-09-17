package com.scrumapp.scrum.services;

import com.scrumapp.scrum.models.Project;
import com.scrumapp.scrum.repositories.IProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final IProjectRepository iProjectRepository;

    // Inyección de dependencias vía constructor
    public ProjectService(IProjectRepository iProjectRepository) {
        this.iProjectRepository = iProjectRepository;
    }

    // Crear un proyecto
    public Project createProject(Project project) {
        return iProjectRepository.save(project);
    }

    // Obtener un proyecto por ID
    public Optional<Project> getProjectById(Long id) {
        return iProjectRepository.findById(id);
    }

    // Obtener todos los proyectos
    public List<Project> getAllProjects() {
        return iProjectRepository.findAll();
    }

    // Actualizar un proyecto
    public Project updateProject(Long id, Project projectDetails) {
        Project project = iProjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        return iProjectRepository.save(project);
    }

    // Eliminar un proyecto
    public void deleteProject(Long id) {
        Project project = iProjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        iProjectRepository.delete(project);
    }
}
