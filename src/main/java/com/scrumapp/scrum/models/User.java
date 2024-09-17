package com.scrumapp.scrum.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
//@Table(name = "user")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks;

    // Relación Many-to-Many con Project
    @ManyToMany(mappedBy = "users")
    @JsonBackReference // Lado inverso de la relación
    private List<Project> projectList;

    // Getters y Setters
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public java.util.List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(java.util.List<Project> projectList) {
        this.projectList = projectList;
    }
}
