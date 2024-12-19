package be.storm.rulecrafterbackend.api.models.dtos.character;

import be.storm.rulecrafterbackend.dl.entities.character.Character;

import be.storm.rulecrafterbackend.dl.entities.character.Description;

import be.storm.rulecrafterbackend.dl.entities.character.Proficiency;

import be.storm.rulecrafterbackend.dl.entities.character.SavingThrow;
import be.storm.rulecrafterbackend.dl.entities.enums.character.Alignment;
import java.util.List;

public record CharacterDTO(
    Long id,
    String name,
    int hp,
    String race,
    Alignment alignment,
    String backstory,
    Description description,
    List<StatDTO> stats,
    List<FeatDTO> feats,
    List<ClassLevelDTO> classes,
    List<SavingThrow> savingThrows,
    List<Proficiency> proficiencies,
    List<SpellDTO> spells,
    List<ItemDTO> items,
    String background
) {

  public static CharacterDTO fromCharacter(Character character) {
    return new CharacterDTO(
        character.getId(),
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
