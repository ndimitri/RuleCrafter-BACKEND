package be.storm.rulecrafterbackend.api.controllers.security;

import be.storm.rulecrafterbackend.api.models.forms.user.UserForm;
import be.storm.rulecrafterbackend.bll.services.user.UserService;
import be.storm.rulecrafterbackend.bll.services.security.AuthService;
import be.storm.rulecrafterbackend.dl.entities.user.User;
import be.storm.rulecrafterbackend.il.utils.JwtUtils;
import be.storm.rulecrafterbackend.api.models.dtos.user.UserDTO;
import be.storm.rulecrafterbackend.api.models.dtos.user.UserTokenDTO;
import be.storm.rulecrafterbackend.api.models.forms.user.LoginForm;
import be.storm.rulecrafterbackend.api.models.forms.user.RegisterForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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


    @PostMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<UserTokenDTO> login(@Valid @RequestBody LoginForm form) {
        User user = authService.login(form.toUser());
        UserDTO dto = UserDTO.fromUser(user);
        UserTokenDTO tokenDTO = new UserTokenDTO(dto, jwtUtils.generateToken(user));
        return ResponseEntity.ok(tokenDTO);
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<Void> register(
            @RequestPart(name = "image", required = false) MultipartFile image,
            @RequestPart(name = "form") RegisterForm form
    ) {
        authService.register(form.toUser(), image);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/profile")
    public ResponseEntity<UserDTO> updateProfile(
            @RequestPart(name = "image", required = false) MultipartFile image,
            @RequestPart(name = "form") UserForm form,
            Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();
        User updatedUser = authService.updateProfile(user, form, image);
        return ResponseEntity.ok(UserDTO.fromUser(updatedUser));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(UserDTO.fromUser(user));
    }
}

