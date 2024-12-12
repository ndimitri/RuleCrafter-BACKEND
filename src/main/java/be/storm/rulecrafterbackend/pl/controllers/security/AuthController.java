package be.storm.rulecrafterbackend.pl.controllers.security;

import be.storm.rulecrafterbackend.bll.services.UserService;
import be.storm.rulecrafterbackend.bll.services.security.AuthService;
import be.storm.rulecrafterbackend.dl.entities.user.User;
import be.storm.rulecrafterbackend.il.utils.JwtUtils;
import be.storm.rulecrafterbackend.pl.models.dtos.user.UserDTO;
import be.storm.rulecrafterbackend.pl.models.dtos.user.UserTokenDTO;
import be.storm.rulecrafterbackend.pl.models.forms.user.LoginForm;
import be.storm.rulecrafterbackend.pl.models.forms.user.RegisterForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final AuthService authService;

//    public ResponseEntity<User> registerUser(@RequestBody RegisterForm form) {
//
//        authService.register(form.toUser());
//        return ResponseEntity.noContent().build();
//    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenDTO> login(
            @Valid @RequestBody LoginForm form
    ) {
        User user = authService.login(form.toUser());
        UserDTO dto = UserDTO.fromUser(user);
        UserTokenDTO tokenDTO = new UserTokenDTO(dto, jwtUtils.generateToken(user));
        return ResponseEntity.ok(tokenDTO);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Void> register(
            @RequestPart(name = "image", required = false) MultipartFile image,
            @RequestPart(name = "form") RegisterForm form
    ) {
        authService.register(form.toUser(), image);
        return ResponseEntity.noContent().build();
    }
}


/*
@RestController: Marks the class as a REST controller.
@RequestMapping("/auth"): Maps requests to /auth URL.
registerUser(@RequestBody User user): Handles user registration.
getCurrentUser(): Returns the current authenticated user.
The @CrossOrigin annotation on the controller allows CORS requests from the specified origin (http://localhost:4200).
 */