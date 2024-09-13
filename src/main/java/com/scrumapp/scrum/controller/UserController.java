package com.scrumapp.scrum.controller;

import com.scrumapp.scrum.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public String getAllUsers() {
        // Lógica para obtener todos los usuarios
        return "List of users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        // Lógica para obtener un usuario por su ID
        return "User details";
    }

    @PostMapping
    public String createUser(@RequestBody UserRequest userRequest) {
        // Lógica para crear un nuevo usuario
        return "User created";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        // Lógica para actualizar un usuario
        return "User updated";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        // Lógica para eliminar un usuario
        return "User deleted";
    }
}
