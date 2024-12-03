package be.storm.rulecrafterbackend.bll.character;

import lombok.Getter;

@Getter
public class AbilityDetail {

  private String name;
  private int score;

  public AbilityDetail(String name, int score) {
    this.name = name;
    this.score = score;
  }

}
