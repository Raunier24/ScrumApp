package com.scrumapp.scrum.service;

import com.scrumapp.models.Project;
import com.scrumapp.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public ResponseEntity<Project> getProjectById(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        return ResponseEntity.ok(project);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public ResponseEntity<Project> updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            project.setName(projectDetails.getName());
            projectRepository.save(project);
        }
        return ResponseEntity.ok(project);
    }

    public ResponseEntity<Void> deleteProject(Long id) {
        projectRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
