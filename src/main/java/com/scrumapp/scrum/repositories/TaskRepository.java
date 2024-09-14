package com.scrumapp.scrum.repositories;

import com.scrumapp.scrum.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
