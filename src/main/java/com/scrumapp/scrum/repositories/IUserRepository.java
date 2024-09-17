package com.scrumapp.scrum.repositories;

import com.scrumapp.scrum.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Método opcional para buscar por nombre de usuario
}
