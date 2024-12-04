package be.storm.rulecrafterbackend.pl.models.dtos.user;

import be.storm.rulecrafterbackend.dl.entities.user.User;

public record UserDTO(
        long id,
        String username,
        String email
) {
    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail());
    }
}
