package be.storm.rulecrafterbackend.bll.character;

import be.storm.rulecrafterbackend.dal.models.classResponse.DnDClassResponse;
import be.storm.rulecrafterbackend.dal.models.classResponse.ProficiencyChoice;
import be.storm.rulecrafterbackend.dal.models.classResponse.SavingThrow;
import be.storm.rulecrafterbackend.dl.entities.enums.Ability;
import com.fasterxml.jackson.annotation.JsonProperty;
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

  @JsonProperty("name")
  private String name;

  @JsonProperty("hit_die")
  private int hitPointDie;

  @JsonProperty("saving_throws")
  private List<SavingThrow> savingThrows;


//  @JsonProperty("proficiency_choices")
//  private List<ProficiencyChoice> proficiencyChoices;


//
//  List<Feature> features;
//
//  List<Skill> skills;
//
//  List<WeaponMastery> weaponMasteries;


//  public ClassType(DnDClassResponse dndClassResponse) {
//    // Mappe les champs simples
//    this.setName(dndClassResponse.getName());
//    this.setHitPointDie(dndClassResponse.getHit_die());
//
//    // Mappe le champ primaryAbility (par exemple, STR)
//    Ability primaryAbility = Ability.getByApiIndex(dndClassResponse.getSaving_throws().get(0).getIndex());
//    this.setPrimaryAbility(primaryAbility);
//  }

}
