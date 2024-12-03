package be.storm.rulecrafterbackend.bll.character;

import be.storm.rulecrafterbackend.dl.entities.character.Character;
import be.storm.rulecrafterbackend.dl.entities.enums.Alignment;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class CharacterDTO {

  private Long id;

  private String name;

  private ClassType classType;

//  private Race race;

  private Alignment alignment;

  private Abilities abilities;


  private int hp;



  public CharacterDTO(Character character, ClassType classType) {
    this.id = character.getId();
    this.name = character.getName();
    this.alignment = character.getAlignment();
    this.abilities = new Abilities(character.getAbilities());
    this.hp = character.getHp();
    this.classType = classType;
  }




}
