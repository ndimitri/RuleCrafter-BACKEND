package be.storm.rulecrafterbackend.dal.models.classResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeatureResponse {
  private String index;
  private String name;
  private String url;
}