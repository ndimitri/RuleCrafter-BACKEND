package be.storm.rulecrafterbackend.il.initializers;

import be.storm.rulecrafterbackend.dal.CharacterFullRepository;
import be.storm.rulecrafterbackend.dl.entities.character.AbilityStats;
import be.storm.rulecrafterbackend.dl.entities.character.CharacterFull;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

  private final CharacterFullRepository characterFullRepository;

  @Override
  public void run(String... args) throws Exception {
    if(characterFullRepository.count() == 0) {
      // Exemple de personnage 1
      CharacterFull thalanor = new CharacterFull();
      thalanor.setName("Thalanor");
      thalanor.setClassType("Magicien");
      thalanor.setRace("Elfe");
      thalanor.setAlignment("Neutre Bon");
      thalanor.setLevel(5);
      thalanor.setHitPointsMax(38);
      thalanor.setHitPointsCurrent(28);
      thalanor.setLanguages(List.of("Elfe", "Commun"));
      thalanor.setSkills(Map.of(
          "Arcane", 8,
          "Histoire", 7,
          "Perception", 5
      ));
      thalanor.setAttacks(List.of("Rayon de givre", "Boule de feu"));
      thalanor.setInventory(List.of("Bâton magique", "Livre de sorts"));
      thalanor.setFeatures(List.of("Vision dans le noir", "Résistance aux charmes"));
      AbilityStats abilityStats = new AbilityStats();
      abilityStats.setStr(5);
      abilityStats.setDex(10);
      abilityStats.setIntel(5);
      abilityStats.setCha(6);
      abilityStats.setCon(9);
      abilityStats.setWis(8);
//      thalanor.setAbilities(Map.of(
//          "str", 5,
//          "dex" , 6,
//          "wis" , 8,
//          "con" , 10,
//          "cha" , 3,
//          "int" , 5
//      ));
      thalanor.setAbilities(abilityStats);


      // Exemple de personnage 2
      CharacterFull gorran = new CharacterFull();
      gorran.setName("Gorran le Brave");
      gorran.setClassType("Guerrier");
      gorran.setRace("Humain");
      gorran.setAlignment("Loyal Bon");
      gorran.setLevel(4);
      gorran.setHitPointsMax(42);
      gorran.setHitPointsCurrent(36);
      gorran.setLanguages(List.of("Commun", "Nain"));
      gorran.setSkills(Map.of(
          "Athlétisme", 7,
          "Intimidation", 6
      ));
      gorran.setAttacks(List.of("Épée longue", "Hache de bataille"));
      gorran.setInventory(List.of("Armure lourde", "Bouclier d'acier"));
      gorran.setFeatures(List.of("Attaque supplémentaire", "Défenseur robuste"));
      AbilityStats abilityStats2 = new AbilityStats();
      abilityStats2.setStr(7);
      abilityStats2.setDex(7);
      abilityStats2.setIntel(7);
      abilityStats2.setCha(7);
      abilityStats2.setCon(7);
      abilityStats2.setWis(7);
      gorran.setAbilities(abilityStats2);

      characterFullRepository.saveAll(List.of(thalanor, gorran));

    }


  }
}
