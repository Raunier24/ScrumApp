package com.scrumapp.scrum.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id project")
    private Long idProject;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    // Relación Many-to-Many con User
    @ManyToMany
    @JoinTable(
            name = "project_user", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "project_id"), // Columna de esta entidad
            inverseJoinColumns = @JoinColumn(name = "user_id") // Columna de la otra entidad
    )

    @JsonManagedReference // Lado propietario de la relación
    private List<User> users;

    // Getters and Setters
    public Long getId() {
        return idProject;
    }

    public void setId(Long id) {
        this.idProject = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
