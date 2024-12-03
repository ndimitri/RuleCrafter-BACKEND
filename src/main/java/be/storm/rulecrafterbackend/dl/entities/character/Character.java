package be.storm.rulecrafterbackend.dl.entities.character;


import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import be.storm.rulecrafterbackend.dl.entities.enums.Alignment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;

@Entity
public class Character extends BaseEntity {

  @Column(nullable = false)
  private String name;

  private String classTypeUrl;  // URL vers l'API DnD pour la classe

  private String raceUrl; // URL vers l'API DnD pour la race

  @Enumerated(EnumType.STRING)
  private Alignment alignment;

  @OneToOne(cascade = CascadeType.ALL)
  private AbilityStats abilities;

  private int hp;

}
