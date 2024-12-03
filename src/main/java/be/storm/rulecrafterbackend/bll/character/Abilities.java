package be.storm.rulecrafterbackend.bll.character;

import be.storm.rulecrafterbackend.dl.entities.character.AbilityStats;
import be.storm.rulecrafterbackend.dl.entities.enums.Ability;
import java.util.HashMap;
import java.util.Map;

public class Abilities {
  private Map<Ability, AbilityDetail> abilities = new HashMap<>();



  public Abilities(AbilityStats stats) {
    abilities.put(Ability.STR, new AbilityDetail(Ability.STR.name(), stats.getStr()));
    abilities.put(Ability.DEX, new AbilityDetail(Ability.DEX.name(), stats.getDex()));
    abilities.put(Ability.CON, new AbilityDetail(Ability.CON.name(), stats.getCon()));
    abilities.put(Ability.INT, new AbilityDetail(Ability.INT.name(), stats.getIntel()));
    abilities.put(Ability.WIS, new AbilityDetail(Ability.WIS.name(), stats.getWis()));
    abilities.put(Ability.CHA, new AbilityDetail(Ability.CHA.name(), stats.getCha()));
  }

  public Map<Ability, AbilityDetail> getAbilities() {
    return abilities;
  }

  public AbilityDetail getAbility(Ability ability) {
    return abilities.get(ability);
  }

}
