package be.storm.rulecrafterbackend.il.initializers;

import be.storm.rulecrafterbackend.dal.character.CharacterRepository;

import be.storm.rulecrafterbackend.dl.entities.character.Character;

import be.storm.rulecrafterbackend.dl.entities.character.ClassLevel;
import be.storm.rulecrafterbackend.dl.entities.character.Description;
import be.storm.rulecrafterbackend.dl.entities.character.Feat;
import be.storm.rulecrafterbackend.dl.entities.character.Item;
import be.storm.rulecrafterbackend.dl.entities.character.Price;
import be.storm.rulecrafterbackend.dl.entities.character.Proficiency;
import be.storm.rulecrafterbackend.dl.entities.character.SavingThrow;
import be.storm.rulecrafterbackend.dl.entities.character.Spell;
import be.storm.rulecrafterbackend.dl.entities.character.Stat;
import be.storm.rulecrafterbackend.dl.entities.enums.character.Alignment;
import be.storm.rulecrafterbackend.dl.entities.enums.character.ItemRarity;
import be.storm.rulecrafterbackend.dl.entities.enums.character.ItemType;
import be.storm.rulecrafterbackend.dl.entities.enums.character.MagicSchool;
import be.storm.rulecrafterbackend.dl.entities.enums.character.SpellLevel;

import java.util.List;
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

      //Création Character 1

      Character nike = new Character();
      nike.setName("Theo Bernardus");
      nike.setHp(15);
      nike.setRace("human");
      nike.setAlignment(Alignment.LAWFUL_GOOD);
      nike.setBackstory("Un membre de la secte X au carré");

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
      List<SavingThrow> savingThrows = List.of(
          new SavingThrow("Strength",2),
          new SavingThrow("Dexterity",0),
          new SavingThrow("Constitution",0),
          new SavingThrow("Intelligence",0),
          new SavingThrow("Wisdom",0),
          new SavingThrow("Charisma",0)
      );
      nike.setSavingThrows(savingThrows);

      // Proficiencies
      List<Proficiency> proficiencies = List.of(
        new Proficiency("Acrobatics", 2, "dex") ,
        new Proficiency("Arcana", 3, "int") ,
        new Proficiency("Animal Handling", 1, "wis")
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
      nike.setSpells(spells);


      // Background
      nike.setBackground("Sage");

      // Sauvegarde
      characterRepository.save(nike);





      //Création Character 2

      Character character2 = new Character();
      character2.setName("Nikus Dimitrius");
      character2.setHp(20);
      character2.setRace("elf");
      character2.setAlignment(Alignment.NEUTRAL_EVIL);
      character2.setBackstory("Loup solitaire en quête d'aventure et de repoussement de ses limites. Il se balade à la recherche d'un maître au sommet de l'art de l'épée");

      // Description
      Description descriptionChar2 = new Description("24", "190cm", "85kg", "green", "white", "blond");
      character2.setDescription(descriptionChar2);

      // Stats
      List<Stat> statsChar2 = List.of(
          new Stat("strength", "str", 15),
          new Stat("dexterity", "dex", 14),
          new Stat("constitution", "con", 15),
          new Stat("intelligence", "int", 10),
          new Stat("wisdom", "wis", 5),
          new Stat("charisma", "cha", 12)
      );
      character2.setStats(statsChar2);

      // Feats
      List<Feat> featsChar2 = List.of(
          new Feat("Elf Weapon Training", "You have proficiency with the longsword, shortsword, shortbow, and longbow.", List.of())
      );
      character2.setFeats(featsChar2);

      // Classes
      List<ClassLevel> classLevelsChar2 = List.of(
          new ClassLevel("warlock", 1)
      );
      character2.setClasses(classLevelsChar2);

      // Saving Throws
      List<SavingThrow> savingThrowsChar2 = List.of(
          new SavingThrow("Strength",2),
          new SavingThrow("Dexterity",1),
          new SavingThrow("Constitution",1),
          new SavingThrow("Intelligence",0),
          new SavingThrow("Wisdom",0),
          new SavingThrow("Charisma",0)
      );
      character2.setSavingThrows(savingThrowsChar2);

      // Proficiencies
      List<Proficiency> proficienciesChar2 = List.of(
          new Proficiency("Athletics", 3, "str") ,
          new Proficiency("Sleight of Hand", 1, "dex")
      );
      character2.setProficiencies(proficienciesChar2);


      // Items
      List<Item> itemsChar2 = List.of(
          new Item("Lytta", "Epée aussi brillante que sanglante, aussi appelé 'Lame du sang'.", "2kg", ItemRarity.VERY_RARE, ItemType.WEAPON, new Price(15000, "gold"), List.of())
      );
      character2.setItems(itemsChar2);

      //Spells
      List<Spell> spellsChar2 = List.of(
          new Spell("Wind Movement", SpellLevel.LEVEL_6, MagicSchool.ENCHANTMENT, "1s", "50m", "10s", "Englobe l'épée d'une fine couche de vent pouvant emporter des montagnes entières", List.of())
      );
      character2.setSpells(spellsChar2);


      // Background
      character2.setBackground("Ermite");

      characterRepository.save(character2);

    }


  }
}
