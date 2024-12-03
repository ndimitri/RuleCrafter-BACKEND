package be.storm.rulecrafterbackend.dal.models.classResponse;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Classe représentant la réponse avec les features
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeatureListResponse {
  private List<FeatureResponse> results;


}
