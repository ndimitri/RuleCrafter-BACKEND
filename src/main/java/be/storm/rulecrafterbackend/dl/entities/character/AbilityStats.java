package be.storm.rulecrafterbackend.dl.entities.character;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class AbilityStats extends BaseEntity {

  private int str;
  private int wis;
  private int dex;
  private int con;
  private int cha;
  private int intel;


}
