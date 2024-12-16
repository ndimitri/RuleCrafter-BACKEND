package be.storm.rulecrafterbackend.bll.services.security.impls;

import be.storm.rulecrafterbackend.bll.services.security.AuthService;
import be.storm.rulecrafterbackend.dal.repositories.UserRepository;
import be.storm.rulecrafterbackend.dl.entities.user.User;
import be.storm.rulecrafterbackend.api.models.dtos.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(User user, MultipartFile image) {
        if(userRepository.existsByUsernameOrEmail(user.getUsername(),user.getEmail())){
            throw new RuntimeException("User with mail " + user.getEmail() + " already exists");
        }

        if(image != null && !image.isEmpty()){
            String imageUrl = saveImage(image);
            user.setPicture(imageUrl);
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

    public User updateProfile(User user, UserDTO userDTO, MultipartFile image) {

        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());


        if (image != null && !image.isEmpty()) {
            String imageUrl = saveImage(image);
            user.setPicture(imageUrl);
        }

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }



    private String saveImage(MultipartFile image) {

        String imageName = UUID.randomUUID() + "_" + image.getOriginalFilename();
        Path imagePath = Path.of(System.getProperty("user.dir"), "images", imageName);
        try {
            Files.write(imagePath, image.getBytes());
            return imageName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
