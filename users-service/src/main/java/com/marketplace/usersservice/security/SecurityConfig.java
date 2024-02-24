package com.marketplace.usersservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    // Configuración del AuthenticationManager
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Configuración del codificador de contraseñas (BCryptPasswordEncoder)
    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    // Creación de un filtro personalizado para autenticación basada en JWT
    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    // Configuración de la cadena de filtros de seguridad HTTP
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Desactiva la protección CSRF
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)  // Configura el punto de entrada para errores de autenticación JWT
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Configura la política de creación de sesiones como STATELESS (sin sesiones)
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/user/**", "api/user/create").permitAll() // Permite acceso sin autenticación a las páginas de inicio, registro y login
                .anyRequest().authenticated()  // Requiere autenticación para cualquier otra solicitud
                .and()
                .httpBasic();  // Configura la autenticación básica HTTP

        // Agrega el filtro personalizado JwtAuthenticationFilter antes del filtro de autenticación de nombre de usuario y contraseña
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        // Construye y devuelve la cadena de filtros de seguridad configurada
        return http.build();
    }
}