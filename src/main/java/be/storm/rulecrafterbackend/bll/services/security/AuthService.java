package be.storm.rulecrafterbackend.bll.services.security;

import be.storm.rulecrafterbackend.dl.entities.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    void register(User user);
    User login(User user);
}
