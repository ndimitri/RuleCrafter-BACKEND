package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.dal.repositories.UserRepository;
import be.storm.rulecrafterbackend.dl.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    // Dependencies
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        if(userRepository.existsByUsernameOrEmail(user.getUsername(),user.getEmail())){
            throw new RuntimeException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
