package be.storm.rulecrafterbackend.bll.character;

import be.storm.rulecrafterbackend.dl.entities.enums.Alignment;

public class CharacterDTO {

  private Long id;

  private String name;

  private ClassType classType;

  private Race race;

  private Alignment alignment;

  private Abilities abilities;

  private int hp;
}
