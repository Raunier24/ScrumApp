package com.scrumapp.scrum.services;

import com.scrumapp.scrum.dtos.request.RegisterRequest;
import com.scrumapp.scrum.dtos.request.LoginRequest;
import com.scrumapp.scrum.dtos.response.AuthResponse;
import com.scrumapp.scrum.models.User;
import com.scrumapp.scrum.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    // Constructor manual
    public AuthService(JwtService jwtService, UserRepository userRepository,
                       PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse login(LoginRequest login) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
        );

        User user = userRepository.findByUsername(login.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.getTokenService(user);

        return new AuthResponse(token, user.getRole()); // Asegúrate de devolver el rol
    }

    public AuthResponse register(RegisterRequest register) {
        User user = new User();
        user.setUsername(register.getUsername());
        user.setEmail(register.getEmail());
        user.setPassword(passwordEncoder.encode(register.getPassword()));
        user.setRole(register.getRole());

        userRepository.save(user);

        return new AuthResponse(
                jwtService.getTokenService(user),
                register.getRole()
        );
    }
}