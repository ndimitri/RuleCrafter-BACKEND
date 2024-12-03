package be.storm.rulecrafterbackend.bll.character;

import be.storm.rulecrafterbackend.dl.entities.enums.Ability;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ClassType {

  String name;

  Ability primaryAbility;

  int hitPointDie;

  List<Ability> savingThrows;

  List<Feature> features;

  List<Skill> skills;

  List<WeaponMastery> weaponMasteries;
}
