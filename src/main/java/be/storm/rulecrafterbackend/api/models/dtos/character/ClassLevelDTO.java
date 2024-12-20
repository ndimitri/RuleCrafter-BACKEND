package be.storm.rulecrafterbackend.api.models.dtos.character;

import be.storm.rulecrafterbackend.dl.entities.character.ClassLevel;

public record ClassLevelDTO(
    String name,
    int level
) {

  public static ClassLevelDTO fromClassLevel(ClassLevel classLevel){
    return new ClassLevelDTO(
        classLevel.getName(),
        classLevel.getLevel()
    );
  }

}
