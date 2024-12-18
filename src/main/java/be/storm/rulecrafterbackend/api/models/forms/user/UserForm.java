package be.storm.rulecrafterbackend.api.models.forms.user;

import be.storm.rulecrafterbackend.dl.entities.user.User;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserForm(
        @NotBlank @Id
        Long id,
        @NotBlank
        String username,
        @NotBlank @Email
        String email
) {

    public static UserForm fromUser(User user) {

        String picture = user.getPicture() != null ? user.getPicture() : "http://localhost:8080/images/default-profile.jpg";
        return new UserForm(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}