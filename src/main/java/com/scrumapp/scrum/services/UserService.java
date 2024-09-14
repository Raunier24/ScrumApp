package com.scrumapp.scrum.services;

import com.scrumapp.scrum.models.User;
import com.scrumapp.scrum.dto.UserRequest;
import com.scrumapp.scrum.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Inyección de dependencias manual
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return ResponseEntity.ok(user);
    }

    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole(userRequest.getRole());
        return userRepository.save(user);
    }

    public ResponseEntity<User> updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(userRequest.getUsername());
            user.setEmail(userRequest.getEmail());
            user.setRole(userRequest.getRole());
            userRepository.save(user);
        }
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<Void> deleteUser(Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
