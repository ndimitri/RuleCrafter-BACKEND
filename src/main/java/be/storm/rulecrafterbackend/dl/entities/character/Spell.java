package be.storm.rulecrafterbackend.dl.entities.character;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import be.storm.rulecrafterbackend.dl.entities.enums.MagicSchool;
import be.storm.rulecrafterbackend.dl.entities.enums.SpellLevel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spells")
public class Spell extends BaseEntity {
  private String name;

  @Enumerated(EnumType.STRING)
  private SpellLevel level;

  @Enumerated(EnumType.STRING)
  private MagicSchool school;
  private String castingTime;
  private String range;
  private String duration;
  private String description;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "spell_id")
  private List<RollableProprety> rollableProps = new ArrayList<>();

}
