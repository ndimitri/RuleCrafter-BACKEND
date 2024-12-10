package be.storm.rulecrafterbackend.dl.entities.character;


import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import be.storm.rulecrafterbackend.dl.entities.enums.Alignment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "characters")
public class Character extends BaseEntity {

  private String name;
  private int hp;
  private String race;

  @Enumerated(EnumType.STRING)
  private Alignment alignment;
  private String backstory;

  @Embedded
  private Description description;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "character_id")
  private List<Stat> stats = new ArrayList<>();


  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "character_id")
  private List<Feat> feats = new ArrayList<>();


  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "character_id")
  private List<ClassLevel> classes = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "saving_throws", joinColumns = @JoinColumn(name = "character_id"))
  @MapKeyColumn(name = "stat_name")
  @Column(name = "saving_throw_value")
  private Map<String, Integer> savingThrows = new HashMap<>();


  @ElementCollection
  @CollectionTable(name = "proficiencies", joinColumns = @JoinColumn(name = "character_id"))
  @MapKeyColumn(name = "proficiency_name")
  @Column(name = "proficiency_level")
  private Map<String, Proficiency> proficiencies = new HashMap<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "character_id")
  private List<Spell> spells = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "character_id")
  private List<Item> items = new ArrayList<>();

  private String background;

}
