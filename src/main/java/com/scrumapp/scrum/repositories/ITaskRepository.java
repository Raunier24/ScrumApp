package com.scrumapp.scrum.repositories;

import com.scrumapp.scrum.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
    // Cambia 'userId' por 'user.idUser'
    List<Task> findByUserIdUser(Long userId);

    // Cambia 'projectId' por 'project.id'
    List<Task> findByProjectId(Long projectId);
}