package be.storm.rulecrafterbackend.bll.services.security;

import be.storm.rulecrafterbackend.api.models.forms.user.UserForm;
import be.storm.rulecrafterbackend.dl.entities.user.User;
import be.storm.rulecrafterbackend.api.models.dtos.user.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

public interface AuthService extends UserDetailsService {

    void register(User user, MultipartFile image);
    User login(User user);
    User updateProfile(User user, UserForm form, MultipartFile image);
}
