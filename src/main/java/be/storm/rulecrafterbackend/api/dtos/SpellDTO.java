package be.storm.rulecrafterbackend.api.dtos;

import be.storm.rulecrafterbackend.dl.entities.character.RollableProprety;
import be.storm.rulecrafterbackend.dl.entities.character.Spell;
import be.storm.rulecrafterbackend.dl.entities.enums.MagicSchool;
import be.storm.rulecrafterbackend.dl.entities.enums.SpellLevel;
import java.util.List;

public record SpellDTO(
    String name,
    SpellLevel level,
    MagicSchool school,
    String castingTime,
    String range,
    String duration,
    String description,
    List<RollablePropretyDTO> rollableProps
) {

  public static SpellDTO fromSpell(Spell spell) {
    return new SpellDTO(
      spell.getName(),
      spell.getLevel(),
      spell.getSchool(),
      spell.getCastingTime(),
      spell.getRange(),
      spell.getDuration(),
      spell.getDescription(),
      spell.getRollableProps().stream().map(RollablePropretyDTO::fromRollableProprety).toList()
    );
  }

}
