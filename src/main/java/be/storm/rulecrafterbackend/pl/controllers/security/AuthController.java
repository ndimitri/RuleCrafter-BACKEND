package be.storm.rulecrafterbackend.pl.controllers.security;

import be.storm.rulecrafterbackend.bll.services.UserService;
import be.storm.rulecrafterbackend.dl.entities.user.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<User> registerUser(@RequestBody User user) {

        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        userService.saveUser(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login")
    public ResponseEntity<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        return userService.findByUsername(currentUsername)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}


/*
@RestController: Marks the class as a REST controller.
@RequestMapping("/auth"): Maps requests to /auth URL.
registerUser(@RequestBody User user): Handles user registration.
getCurrentUser(): Returns the current authenticated user.
The @CrossOrigin annotation on the controller allows CORS requests from the specified origin (http://localhost:4200).
 */