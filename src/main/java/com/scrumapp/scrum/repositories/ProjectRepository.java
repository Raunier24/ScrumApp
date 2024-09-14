package com.scrumapp.scrum.repositories;

import com.scrumapp.scrum.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
