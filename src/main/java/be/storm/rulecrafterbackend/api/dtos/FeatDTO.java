package be.storm.rulecrafterbackend.api.dtos;

import be.storm.rulecrafterbackend.dl.entities.character.Feat;
import be.storm.rulecrafterbackend.dl.entities.character.RollableProprety;
import java.util.List;

public record FeatDTO(
    String name,
    String notes,
    List<RollablePropretyDTO> rollableProps
) {

  public static FeatDTO fromFeat(Feat feat){
    return new FeatDTO(
        feat.getName(),
        feat.getNotes(),
        feat.getRollableProps().stream().map(RollablePropretyDTO::fromRollableProprety).toList()
    );
  }

}
