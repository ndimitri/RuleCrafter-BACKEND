package be.storm.rulecrafterbackend.pl.models.forms.user;

import be.storm.rulecrafterbackend.dl.entities.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterForm(
        @NotBlank
        String username,
        @NotBlank @Email
        String email,
        String password
) {

    public User toUser(){
        return new User(username, email, password);
    }

}
