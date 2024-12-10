package be.storm.rulecrafterbackend.il.initializers;

import be.storm.rulecrafterbackend.dal.CharacterRepository;

import be.storm.rulecrafterbackend.dl.entities.character.Character;

import be.storm.rulecrafterbackend.dl.entities.character.ClassLevel;
import be.storm.rulecrafterbackend.dl.entities.character.Description;
import be.storm.rulecrafterbackend.dl.entities.character.Feat;
import be.storm.rulecrafterbackend.dl.entities.character.Item;
import be.storm.rulecrafterbackend.dl.entities.character.Price;
import be.storm.rulecrafterbackend.dl.entities.character.Proficiency;
import be.storm.rulecrafterbackend.dl.entities.character.Spell;
import be.storm.rulecrafterbackend.dl.entities.character.Stat;
import be.storm.rulecrafterbackend.dl.entities.enums.Alignment;
import be.storm.rulecrafterbackend.dl.entities.enums.ItemRarity;
import be.storm.rulecrafterbackend.dl.entities.enums.ItemType;
import be.storm.rulecrafterbackend.dl.entities.enums.MagicSchool;
import be.storm.rulecrafterbackend.dl.entities.enums.SpellLevel;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

  private final CharacterRepository characterRepository;

  @Override
  public void run(String... args) throws Exception {

    if(characterRepository.count() == 0){
      Character nike = new Character();
      nike.setName("Nicolus");
      nike.setHp(15);
      nike.setRace("human");
      nike.setAlignment(Alignment.CHAOTIC_NEUTRAL);
      nike.setBackstory("Solo wolf hunter");

      // Description
      Description description = new Description("24", "178cm", "70kg", "brown", "black", "brown");
      nike.setDescription(description);

      // Stats
      List<Stat> stats = List.of(
          new Stat("strength", "str", 9),
          new Stat("dexterity", "dex", 13),
          new Stat("constitution", "con", 15),
          new Stat("intelligence", "int", 7),
          new Stat("wisdom", "wis", 4),
          new Stat("charisma", "cha", 10)
      );
      nike.setStats(stats);

      // Feats
      List<Feat> feats = List.of(
          new Feat("Brave", "You have advantage on saving throw against being frightened.", List.of())
      );
      nike.setFeats(feats);

      // Classes
      List<ClassLevel> classLevels = List.of(
          new ClassLevel("barbarian", 1),
          new ClassLevel("wizard", 1)
      );
      nike.setClasses(classLevels);

      // Saving Throws
      Map<String, Integer> savingThrows = Map.of(
          "Strength", 0,
          "Dexterity", 0,
          "Constitution", 0,
          "Intelligence", 0,
          "Wisdom", 0,
          "Charisma", 0
      );
      nike.setSavingThrows(savingThrows);

      // Proficiencies
      Map<String, Proficiency> proficiencies = Map.of(
          "Acrobatics", new Proficiency(2, "Dexterity"),
          "Animal Handling", new Proficiency(0, "Wisdom"),
          "Arcana", new Proficiency(2, "Intelligence")
      );
      nike.setProficiencies(proficiencies);


      // Items
      List<Item> items = List.of(
          new Item("Hiradia", "Hache ayant appartenu au dieu du caillou", "10kg", ItemRarity.LEGENDARY, ItemType.WEAPON, new Price(13, "gold"), List.of())
      );
      nike.setItems(items);

      //Spells
      List<Spell> spells = List.of(
          new Spell("Déluge", SpellLevel.LEVEL_3, MagicSchool.NECROMANCY, "15s", "100m", "5min", "le plus grand champ de bataille morts", List.of())
      );


      // Background
      nike.setBackground("Sage");

      // Sauvegarde
      characterRepository.save(nike);

    }


  }
}
