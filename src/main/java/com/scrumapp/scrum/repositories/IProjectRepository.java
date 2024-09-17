package com.scrumapp.scrum.repositories;
import com.scrumapp.scrum.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<<< HEAD:src/main/java/com/scrumapp/scrum/repositories/IUserRepository.java
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Método opcional para buscar por nombre de usuario
========
public interface IProjectRepository extends JpaRepository<Project, Long>{
>>>>>>>> dev:src/main/java/com/scrumapp/scrum/repositories/IProjectRepository.java
}
