package be.storm.rulecrafterbackend.dl.entities.enums;

public enum Ability {
  STR("str", "Strength"),
  CHA("cha", "Charisma"),
  CON("con", "Concentration"),
  DEX("dex", "Dexterity"),
  INT("int", "Intelligence"),
  WIS("wis", "Wisdom"),
  ;

  private final String name;
  private final String apiIndex;

  Ability(String apiIndex, String name) {
    this.name = name;
    this.apiIndex = apiIndex;
  }

  public static Ability getByApiIndex(String apiIndex) {
    return switch (apiIndex){
      case "str" -> Ability.STR;
      case "cha" -> Ability.CHA;
      case "con" -> Ability.CON;
      case "dex" -> Ability.DEX;
      case "int" -> Ability.INT;
      case "wis" -> Ability.WIS;
      default -> throw new IllegalStateException("Unexpected apiIndex value: " + apiIndex);
    };
  }
}
