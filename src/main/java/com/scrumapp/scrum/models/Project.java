package com.scrumapp.scrum.models;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_project")
    private Long idProject;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;


    @ManyToMany
    @JoinTable(
            name = "project_user", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "project_id"), // Columna de esta entidad
            inverseJoinColumns = @JoinColumn(name = "user_id") // Columna de la otra entidad
    )

    @JsonManagedReference // Lado propietario de la relación
    private List<User> users;

    // Getters and Setters
    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
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
    public LocalDate getStartDate() { // Agregado el getter para startDate
        return startDate;
    }

    public void setStartDate(LocalDate startDate) { // Agregado el setter para startDate
        this.startDate = startDate;
    }
}
