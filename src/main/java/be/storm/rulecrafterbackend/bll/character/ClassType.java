package be.storm.rulecrafterbackend.bll.character;

import be.storm.rulecrafterbackend.dal.models.classResponse.DnDClassResponse;
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

//  List<Ability> savingThrows;
//
//  List<Feature> features;
//
//  List<Skill> skills;
//
//  List<WeaponMastery> weaponMasteries;


  public ClassType(DnDClassResponse dndClassResponse) {
    // Mappe les champs simples
    this.setName(dndClassResponse.getName());
    this.setHitPointDie(dndClassResponse.getHit_die());

    // Mappe le champ primaryAbility (par exemple, STR)
    Ability primaryAbility = Ability.getByApiIndex(dndClassResponse.getSaving_throws().get(0).getIndex());
    this.setPrimaryAbility(primaryAbility);
  }

}
