package be.storm.rulecrafterbackend.api.dtos;

import be.storm.rulecrafterbackend.dl.entities.character.Stat;

public record StatDTO(
    String name,
    String shortName,
    int value
) {

  public static StatDTO fromStat(Stat stat) {
    return new StatDTO(
        stat.getName(), stat.getShortName(), stat.getValue()
    );
  }
}
