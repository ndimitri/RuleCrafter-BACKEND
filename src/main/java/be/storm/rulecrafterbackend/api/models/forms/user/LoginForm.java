package be.storm.rulecrafterbackend.api.models.forms.user;

import be.storm.rulecrafterbackend.dl.entities.user.User;
import jakarta.validation.constraints.NotBlank;

public record LoginForm(
        @NotBlank
        String username,
        @NotBlank
        String password

) {

        public User toUser(){
                return new User(username, password);
        }
}
