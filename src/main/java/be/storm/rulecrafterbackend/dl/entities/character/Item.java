package be.storm.rulecrafterbackend.dl.entities.character;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import be.storm.rulecrafterbackend.dl.entities.enums.character.ItemRarity;
import be.storm.rulecrafterbackend.dl.entities.enums.character.ItemType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity {
  private String name;
  private String description;
  private String weight;

  @Enumerated(EnumType.STRING)
  private ItemRarity rarity;

  @Enumerated(EnumType.STRING)
  private ItemType type;

  @Embedded
  private Price price;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "item_id")
  private List<RollableProprety> rollableProps = new ArrayList<>();

}
