package be.storm.rulecrafterbackend.dal.models.classResponse;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Classe représentant les détails de la feature
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeatureDetails {
  private String index;
  private String name;
  private int level;
  private List<String> desc;  // Liste de descriptions
  private String url;

}