package com.scrumapp.scrum.repositories;
import com.scrumapp.scrum.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long>{
}
