package be.storm.rulecrafterbackend.api.dtos;

import be.storm.rulecrafterbackend.dl.entities.character.Character;

import be.storm.rulecrafterbackend.dl.entities.character.Description;

import be.storm.rulecrafterbackend.dl.entities.character.Proficiency;

import be.storm.rulecrafterbackend.dl.entities.enums.Alignment;
import java.util.List;
import java.util.Map;

public record CharacterDTO(
    String name,
    int hp,
    String race,
    Alignment alignment,
    String backstory,
    Description description,
    List<StatDTO> stats,
    List<FeatDTO> feats,
    List<ClassLevelDTO> classes,
    Map<String, Integer> savingThrows,
    Map<String, Proficiency> proficiencies,
    List<SpellDTO> spells,
    List<ItemDTO> items,
    String background
) {

  public static CharacterDTO fromCharacter(Character character) {
    return new CharacterDTO(
        character.getName(),
        character.getHp(),
        character.getRace(),
        character.getAlignment(),
        character.getBackstory(),
        character.getDescription(),
        character.getStats().stream().map(StatDTO::fromStat).toList(),
        character.getFeats().stream().map(FeatDTO::fromFeat).toList(),
        character.getClasses().stream().map(ClassLevelDTO::fromClassLevel).toList(),
        character.getSavingThrows(),
        character.getProficiencies(),
        character.getSpells().stream().map(SpellDTO::fromSpell).toList(),
        character.getItems().stream().map(ItemDTO::fromItem).toList(),
        character.getBackground()
    );

  }

}
