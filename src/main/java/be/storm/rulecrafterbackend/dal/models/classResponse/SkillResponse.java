package be.storm.rulecrafterbackend.dal.models.classResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Private class to receive skill response from api
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SkillResponse{
  private String apiIndex;

  private String name;

  private String[] description;
}