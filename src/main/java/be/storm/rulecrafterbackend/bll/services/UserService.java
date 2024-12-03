package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.dal.repositories.UserRepository;
import be.storm.rulecrafterbackend.dl.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class responsible for managing user-related business logic and integrating with
 * the UserRepository for persistence. It also implements the UserDetailsService interface
 * to provide user authentication support in Spring Security.
 */
@Service
public class UserService implements UserDetailsService {

    // Dependencies
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor for UserService.
     * Initializes dependencies, including a PasswordEncoder instance.
     *
     * @param userRepository the UserRepository used for database access
     */
    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Saves a user to the database after encoding their password.
     *
     * @param user the User entity to be saved
     * @return the saved User entity
     */
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user to search for
     * @return an Optional containing the User entity if found, otherwise empty
     */
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    /**
     * Loads a user by their username for Spring Security authentication purposes.
     *
     * @param username the username of the user to load
     * @return UserDetails object containing user credentials and authorities
     * @throws UsernameNotFoundException if no user with the given username is found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + username + " not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER") // Assigning a default authority
                .build();
    }
}
