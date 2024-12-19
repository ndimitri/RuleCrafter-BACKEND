package be.storm.rulecrafterbackend.dl.entities.character;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Description {
  private String age;
  private String height;
  private String weight;
  private String eyes;
  private String skin;
  private String hair;
}
