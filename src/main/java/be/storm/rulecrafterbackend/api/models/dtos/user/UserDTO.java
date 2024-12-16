package be.storm.rulecrafterbackend.api.models.dtos.user;

import be.storm.rulecrafterbackend.dl.entities.user.User;

public record UserDTO(
        long id,
        String username,
        String email,
        String picture // Add the picture field
) {
    public static UserDTO fromUser(User user) {

        String picture = user.getPicture() != null ? user.getPicture() : "http://localhost:8080/images/default-profile.jpg";
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                picture
        );
    }
}
