package be.storm.rulecrafterbackend.api.dtos;

import be.storm.rulecrafterbackend.dl.entities.character.Item;
import be.storm.rulecrafterbackend.dl.entities.character.Price;
import be.storm.rulecrafterbackend.dl.entities.character.RollableProprety;
import be.storm.rulecrafterbackend.dl.entities.enums.ItemRarity;
import be.storm.rulecrafterbackend.dl.entities.enums.ItemType;
import java.util.List;

public record ItemDTO(
    String name,
    String description,
    String weight,
    ItemRarity rarity,
    ItemType type,
    Price price,
    List<RollablePropretyDTO> rollableProps
) {

  public static ItemDTO fromItem(Item item) {
    return new ItemDTO(
      item.getName(),
      item.getDescription(),
      item.getWeight(),
      item.getRarity(),
      item.getType(),
      item.getPrice(),
      item.getRollableProps().stream().map(RollablePropretyDTO::fromRollableProprety).toList()
    );
  }

}
