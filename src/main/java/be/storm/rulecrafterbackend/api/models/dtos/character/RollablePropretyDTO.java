package be.storm.rulecrafterbackend.api.models.dtos.character;

import be.storm.rulecrafterbackend.dl.entities.character.RollableProprety;

public record RollablePropretyDTO(
    String name,
    String magnitude,
    String magnitudeType
) {

  public static RollablePropretyDTO fromRollableProprety(RollableProprety rollableProprety) {
    return new RollablePropretyDTO(
      rollableProprety.getName(),
      rollableProprety.getMagnitude(),
      rollableProprety.getMagnitudeType()
    );
  }

}
