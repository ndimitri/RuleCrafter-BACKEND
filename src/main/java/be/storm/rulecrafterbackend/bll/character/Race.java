package be.storm.rulecrafterbackend.bll.character;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Race {
  private String name;

  List<AbilityBonus> abilityBonuses;

  List<Trait> traits;

}
