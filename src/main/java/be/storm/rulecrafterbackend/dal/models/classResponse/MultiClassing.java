package be.storm.rulecrafterbackend.dal.models.classResponse;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MultiClassing { // Liste des prérequis
  private List<Proficiency> proficiencies;  // Liste des compétences liées au multi-classing

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  public static class Proficiency {
    private String index;
    private String name;
    private String url;
  }
}