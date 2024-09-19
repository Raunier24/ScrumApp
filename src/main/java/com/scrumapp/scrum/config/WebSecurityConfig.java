package com.scrumapp.scrum.config;

import com.scrumapp.scrum.jwt.AuthTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final AuthTokenFilter authTokenFilter;

    public WebSecurityConfig(AuthenticationProvider authenticationProvider, AuthTokenFilter authTokenFilter) {
        this.authenticationProvider = authenticationProvider;
        this.authTokenFilter = authTokenFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf ->
                        csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/api/test/all").permitAll()
                                .requestMatchers("/api/test/user").hasAnyAuthority("ADMIN", "USER")
                                .requestMatchers("/api/test/admin").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/getProject").permitAll ()
                                .requestMatchers("/api/v1/idProject/**").permitAll ()
                                .requestMatchers("/api/v1/createProject").hasAnyAuthority("ADMIN", "GESTOR")
                                .requestMatchers("/api/v1/projectUpdate/**").hasAnyAuthority("ADMIN", "GESTOR")
                                .requestMatchers("/api/v1/deleteProject/**").hasAnyAuthority("ADMIN", "GESTOR")
                                .requestMatchers("/api/v1/getTask").hasAnyAuthority("ADMIN", "GESTOR")
                                .requestMatchers("/api/v1/idTask/**").hasAnyAuthority("ADMIN", "GESTOR")
                                .requestMatchers("/api/v1/createTask").hasAuthority("GESTOR")
                                .requestMatchers("/api/v1/updateTask/**").hasAnyAuthority("USER")
                                .requestMatchers("/api/v1/deleteTask/**").hasAnyAuthority("GESTOR")
                                .requestMatchers("/api/v1/getUser/**").hasAnyAuthority("USER")
                                .requestMatchers("/api/v1/updateProfile/**").hasAnyAuthority("ADMIN")
                                .requestMatchers("/api/v1/userProject/**").hasAnyAuthority("ADMIN")
                                .requestMatchers("/api/v1/getUser").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/idUser/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/createUser").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/updateUser/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/deleteUser/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager ->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}

