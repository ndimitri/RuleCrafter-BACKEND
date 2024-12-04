package be.storm.rulecrafterbackend.dal.models.classResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingThrow {

  @JsonProperty("name")
  String name;
  @JsonProperty("index")
  String index;
  @JsonProperty("url")
  String url;
}
