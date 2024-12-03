package be.storm.rulecrafterbackend.il.configs;

import be.storm.rulecrafterbackend.bll.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Configuration class for Spring Security.
 * Handles authentication, authorization, and security-related configurations.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final UserService userService;

    /**
     * Constructor for SecurityConfig.
     * Injects the UserService to be used for authentication.
     *
     * @param userService the UserService implementation of UserDetailsService
     */
    @Autowired
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    /**
     * Configures the security filter chain for the application.
     *
     * @param http the HttpSecurity object used to customize security behavior
     * @return the configured SecurityFilterChain
     * @throws Exception if any error occurs during configuration
     */
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disables CSRF protection
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").anonymous() // Allows public access to URLs under /auth
                        .anyRequest().authenticated() // Requires authentication for all other requests
                )
                .formLogin(withDefaults()); // Enables form-based login with default configurations

        return http.build();
    }

    /**
     * Configures authentication for the application.
     *
     * @param auth the AuthenticationManagerBuilder for setting up authentication
     * @throws Exception if any error occurs during configuration
     */
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService) // Configures UserService as the source of user data
                .passwordEncoder(passwordEncoder()); // Uses BCryptPasswordEncoder for password hashing
    }

    /**
     * Creates a bean for the PasswordEncoder.
     *
     * @return a BCryptPasswordEncoder instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

/*
Explanation of Key Components
Class-Level Annotations:

@Configuration: Marks this class as a Spring configuration class that defines beans.
@EnableWebSecurity: Enables Spring Security for the application.
Dependencies:

The class depends on UserService, which implements UserDetailsService for loading user details during authentication.
configure(HttpSecurity http):

Configures how HTTP requests are secured.
CSRF Disabled:
Disables CSRF (Cross-Site Request Forgery) protection.
Typically used when the application is an API or does not rely on browser-based form submissions.
Authorization Rules:
requestMatchers("/auth/**").permitAll(): Grants public access to URLs starting with /auth/ (e.g., login and registration pages).
anyRequest().authenticated(): Secures all other endpoints, requiring authentication.
Form Login:
Enables form-based login with default configurations.
configure(AuthenticationManagerBuilder auth):

Configures authentication mechanisms for the application.
Sets up UserService as the source for user authentication.
Uses PasswordEncoder (a BCryptPasswordEncoder instance) for hashing and verifying passwords.
Password Encoder Bean:

Provides a PasswordEncoder bean using BCryptPasswordEncoder.
Ensures secure password storage by hashing passwords before saving them.
How It Works Together
Authentication:

When a user logs in, Spring Security uses UserService to load the user details and verify credentials.
Passwords are hashed using BCryptPasswordEncoder and compared to the hashed passwords stored in the database.
        Authorization:

Public access is granted to /auth/** endpoints.
 All other endpoints require the user to be authenticated.
 Form Login:

 Default Spring Security login form is used to handle user authentication.
 Security Filter Chain:

 Configures the filters applied to incoming HTTP requests, ensuring the security rules are enforced.
 Usage Scenarios
 Public Pages:
 Pages under /auth/** (e.g., login and registration) are accessible to everyone.
 Secured Resources:
 All other resources are protected and require the user to log in.
*/