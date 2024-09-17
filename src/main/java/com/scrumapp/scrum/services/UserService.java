package com.scrumapp.scrum.services;

import com.scrumapp.scrum.models.User;
import com.scrumapp.scrum.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }


    public ResponseEntity<Object> deleteUser(Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
