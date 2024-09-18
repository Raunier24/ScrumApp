package com.scrumapp.scrum.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

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
    private Set<User> users;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
