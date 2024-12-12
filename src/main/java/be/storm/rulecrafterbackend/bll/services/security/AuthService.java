package be.storm.rulecrafterbackend.bll.services.security;

import be.storm.rulecrafterbackend.dl.entities.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

public interface AuthService extends UserDetailsService {

    void register(User user, MultipartFile image);
    User login(User user);
}
