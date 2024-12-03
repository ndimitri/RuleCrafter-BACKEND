package be.storm.rulecrafterbackend.dl.entities.enums;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum Alignment {
  LAWFUL_GOOD("lawful-good", "Lawful Good"),
  LAWFUL_EVIL("lawful-evil", "Lawful Evil"),
  LAWFUL_NEUTRAL("lawful-neutral", "Lawful Neutral"),

  NEUTRAL_GOOD("neutral-good", "Neutral Good"),
  NEUTRAL_EVIL("neutral-evil", "Neutral Evil"),
  NEUTRAL_TRUE("neutral", "True Neutral"),

  CHAOTIC_GOOD("chaotic-good", "Chaotic Good"),
  CHAOTIC_EVIL("chaotic-evil", "Chaotic Evil"),
  CHAOTIC_NEUTRAL("chaotic-neutral", "Chaotic Neutral");


  Alignment(String apiIndex, String name) {
  }


}
