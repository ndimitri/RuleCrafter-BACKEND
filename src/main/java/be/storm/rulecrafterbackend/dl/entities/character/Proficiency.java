package be.storm.rulecrafterbackend.dl.entities.character;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Proficiency {

  private String skillName;
  private int proficiencyLevel;
  private String governingSkill;

}
