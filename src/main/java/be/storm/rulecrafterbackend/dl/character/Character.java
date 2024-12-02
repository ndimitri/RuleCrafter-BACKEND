package be.storm.rulecrafterbackend.dl.character;


import be.storm.rulecrafterbackend.dl.enums.Alignment;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String classTypeUrl;  // URL vers l'API DnD pour la classe

  private String raceUrl; // URL vers l'API DnD pour la race

  @Enumerated(EnumType.STRING)
  private Alignment alignment;

  @ElementCollection
  private List<AbilityScore> abilities;

}
