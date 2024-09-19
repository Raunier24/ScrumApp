package com.scrumapp.scrum.repositories;

import com.scrumapp.scrum.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserIdUser(Long userId);


    List<Task> findByProjectIdProject(Long projectId);
}