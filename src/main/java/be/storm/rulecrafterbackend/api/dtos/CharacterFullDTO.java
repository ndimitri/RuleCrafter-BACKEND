package be.storm.rulecrafterbackend.api.dtos;

import be.storm.rulecrafterbackend.dl.entities.character.AbilityStats;
import be.storm.rulecrafterbackend.dl.entities.character.CharacterFull;
import java.util.List;
import java.util.Map;

public record CharacterFullDTO(
    Long id,
    String name,
    String classType,
    String race,
    String alignement,
    int level,
    int hitPointsMax,
    int hitPointsCurrent,
    List<String> languages,
    Map<String, Integer> skills,
    List<String> attacks,
    List<String> inventory,
    List<String> features,
//    Map<String, Integer> abilities
    AbilityStatsDTO abilities
) {

  public static CharacterFullDTO fromCharacterFull(CharacterFull character) {
    return new CharacterFullDTO(
        character.getId(),
        character.getName(),
        character.getClassType(),
        character.getRace(),
        character.getAlignment(),
        character.getLevel(),
        character.getHitPointsMax(),
        character.getHitPointsCurrent(),
        character.getLanguages(),
        character.getSkills(),
        character.getAttacks(),
        character.getInventory(),
        character.getFeatures(),
        AbilityStatsDTO.fromAbilityStats(character.getAbilities())
    );
  }

}
