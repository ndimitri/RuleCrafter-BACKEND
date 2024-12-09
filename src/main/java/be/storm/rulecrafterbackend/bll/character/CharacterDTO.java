package be.storm.rulecrafterbackend.bll.character;

import be.storm.rulecrafterbackend.dl.entities.character.AbilityStats;
import be.storm.rulecrafterbackend.dl.entities.character.Character;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class CharacterDTO {

  private Long id;

  private String name;

  private ClassType classType;

//  private Race race;

  private String alignment;

//  private Abilities abilities;
  private List<AbilityDetail> abilities;


  private int hp;



  public CharacterDTO(Character character, ClassType classType) {
    this.id = character.getId();
    this.name = character.getName();
    this.alignment = character.getAlignment().getName();
//    this.abilities = new Abilities(character.getAbilities());
    this.abilities = new ArrayList<>();
    setAbilities(character.getAbilities());
    this.hp = character.getHp();
    this.classType = classType;
  }


  public void setAbilities(AbilityStats abilities) {
    this.abilities.add(new AbilityDetail("str", abilities.getStr()));
    this.abilities.add(new AbilityDetail("cha", abilities.getCha()));
    this.abilities.add(new AbilityDetail("con", abilities.getCon()));
    this.abilities.add(new AbilityDetail("int", abilities.getIntel()));
    this.abilities.add(new AbilityDetail("wis", abilities.getWis()));
    this.abilities.add(new AbilityDetail("dex", abilities.getDex()));
  }






}
