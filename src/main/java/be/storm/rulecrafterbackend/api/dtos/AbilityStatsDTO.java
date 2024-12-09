package be.storm.rulecrafterbackend.api.dtos;

import be.storm.rulecrafterbackend.dl.entities.character.AbilityStats;

public record AbilityStatsDTO(
    int str,
    int wis,
    int dex,
    int con,
    int cha,
    int intel
) {

  public static AbilityStatsDTO fromAbilityStats(AbilityStats abilityStats) {
    return new AbilityStatsDTO(
        abilityStats.getStr(),
        abilityStats.getWis(),
        abilityStats.getDex(),
        abilityStats.getCon(),
        abilityStats.getCha(),
        abilityStats.getIntel()
    );
  }

}
