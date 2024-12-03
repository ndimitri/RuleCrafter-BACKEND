package be.storm.rulecrafterbackend.bll.character;

import be.storm.rulecrafterbackend.dl.entities.character.AbilityStats;
import be.storm.rulecrafterbackend.dl.entities.enums.Ability;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class Abilities {

  @JsonUnwrapped
  private Map<String, AbilityDetail> abilities = new HashMap<>();


  public Abilities(AbilityStats stats) {
    abilities.put(Ability.STR.getApiIndex(), new AbilityDetail(Ability.STR.name(), stats.getStr()));
    abilities.put(Ability.DEX.getApiIndex(), new AbilityDetail(Ability.DEX.name(), stats.getDex()));
    abilities.put(Ability.CON.getApiIndex(), new AbilityDetail(Ability.CON.name(), stats.getCon()));
    abilities.put(Ability.INT.getApiIndex(), new AbilityDetail(Ability.INT.name(), stats.getIntel()));
    abilities.put(Ability.WIS.getApiIndex(), new AbilityDetail(Ability.WIS.name(), stats.getWis()));
    abilities.put(Ability.CHA.getApiIndex(), new AbilityDetail(Ability.CHA.name(), stats.getCha()));
  }

  public AbilityDetail getAbility(Ability ability) {
    return abilities.get(ability.getApiIndex());
  }

}
