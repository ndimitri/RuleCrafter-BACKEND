package be.storm.rulecrafterbackend.bll.services.security.impls;

import be.storm.rulecrafterbackend.bll.services.security.AuthService;
import be.storm.rulecrafterbackend.dal.repositories.UserRepository;
import be.storm.rulecrafterbackend.dl.entities.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(User user) {
        if(userRepository.existsByUsernameOrEmail(user.getUsername(),user.getEmail())){
            throw new RuntimeException("User with mail " + user.getEmail() + " already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User login(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername()).orElseThrow();
        if(!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            throw new UsernameNotFoundException(user.getUsername());
        }
        return existingUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
