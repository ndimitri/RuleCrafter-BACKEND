package be.storm.rulecrafterbackend.pl.models.dtos.user;

import be.storm.rulecrafterbackend.dl.entities.user.User;

public record UserTokenDTO(
        UserDTO user,
        String token
) {
}
