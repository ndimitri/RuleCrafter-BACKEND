package be.storm.rulecrafterbackend.bll.services.user;

import be.storm.rulecrafterbackend.dal.repositories.user.UserRepository;
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
            throw new RuntimeException("User With " + user.getUsername() + " already exists or user with" + user.getEmail() + " already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
