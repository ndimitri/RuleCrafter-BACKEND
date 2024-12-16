package be.storm.rulecrafterbackend.api.models.dtos.user;

public record UserTokenDTO(
        UserDTO user,
        String token
) {
}
