package be.storm.rulecrafterbackend.dl.entities.character;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToOne;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterFull extends BaseEntity {

  private String name;
  private String classType;
  private String race;
  private String alignment;
  private int level;

  private int hitPointsMax;
  private int hitPointsCurrent;

  @ElementCollection
  private List<String> languages;

  @ElementCollection
  @CollectionTable(name = "character_skills", joinColumns = @JoinColumn(name = "character_id"))
  @MapKeyColumn(name = "skill_name")
  @Column(name = "skill_value")
  private Map<String, Integer> skills;

  @ElementCollection
  private List<String> attacks;

  @ElementCollection
  private List<String> inventory;

  @ElementCollection
  private List<String> features;

//  @ElementCollection
//  @CollectionTable(name = "character_abilities" , joinColumns = @JoinColumn(name = "character_id"))
//  @MapKeyColumn(name = "ability_name")
//  @Column(name = "ability_value")
//  private Map<String, Integer> abilities;

  @OneToOne(cascade = CascadeType.ALL)
  private AbilityStats abilities;
}
