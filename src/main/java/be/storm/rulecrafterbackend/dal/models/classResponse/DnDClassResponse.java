package be.storm.rulecrafterbackend.dal.models.classResponse;

import be.storm.rulecrafterbackend.bll.character.ClassType;
import be.storm.rulecrafterbackend.bll.character.Feature;
import be.storm.rulecrafterbackend.bll.character.Skill;
import be.storm.rulecrafterbackend.dl.entities.enums.Ability;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DnDClassResponse {

  @JsonProperty("name")
  private String name;

  @JsonProperty("hit_die")
  private int hitPointDie;

  @JsonProperty("saving_throws")
  private List<SavingThrow> saving_throws;

  private List<ProficiencyChoice> proficiency_choices;

  private MultiClassing multi_classing;  // Ajouter ici les données de multi-classing

//  private final WebClient webClient;
//
//  public DnDClassResponse(WebClient.Builder webClientBuilder) {
//    this.webClient = webClientBuilder.baseUrl("https://www.dnd5apie.co/api").build();
//  }




//    // Mappe les savingThrows
//    List<Ability> savingThrows = response.getSaving_throws().stream()
//        .map(st -> {
//          return Ability.getByApiIndex(response.getSaving_throws().get(0).getIndex());
//        })
//        .toList();
//
//    classType.setSavingThrows(savingThrows);
//
//    // Mappe les compétences (skills) avec descriptions
//    List<Skill> skills = new ArrayList<>();
//    for (ProficiencyChoice proficiencyChoice : response.getProficiency_choices()) {
//      for (ProficiencyChoice.Options.Option option : proficiencyChoice.getFrom().getOptions()) {
//        String fullSkillName = option.getItem().getName(); //form : "skill-name_of_the_skill"
//
//        // Récupérer la description de chaque compétence via un autre appel API
//        SkillResponse detailedSkill = getSkillDetails(fullSkillName.substring(6));// Appel API pour récupérer la description
//        Skill skillToAdd = new Skill(detailedSkill.getApiIndex(), detailedSkill.getName(), detailedSkill.getDescription()[0]);
//
//        skills.add(skillToAdd);
//      }
//    }
//    classType.setSkills(skills);
//
//    //Map les features
//    List<FeatureResponse> featureResponses = getClassFeatures(response.getName());
//
//    // Récupérer les détails de chaque feature
//    List<Feature> featureList = new ArrayList<>();
//    for (FeatureResponse feature : featureResponses) {
//      FeatureDetails featureDetails = getFeatureDetails(feature.getIndex());
//
//      // Transformer les détails en une Feature
//      Feature featureToAdd = transformFeatureDetailsToFeature(featureDetails);
//
//      featureList.add(featureToAdd);
//    }
//
//    classType.setFeatures(featureList);


    //TODO Mappe les weaponMasteries




//
//  //UTILS API CALLS
//  private SkillResponse getSkillDetails(String skillName) {
//    return webClient.get()
//        .uri("/skills/{skillName}", skillName)
//        .retrieve()
//        .bodyToMono(SkillResponse.class)
//        .block();
//  }
//
//
//  private List<FeatureResponse> getClassFeatures(String className) {
//    return webClient.get()
//        .uri("/classes/{className}/features", className)
//        .retrieve()
//        .bodyToMono(FeatureListResponse.class)  // Créer une classe pour encapsuler le résultat
//        .block()
//        .getResults();
//  }
//
//
//
//  private FeatureDetails getFeatureDetails(String featureIndex) {
//    return webClient.get()
//        .uri("/features/{featureIndex}", featureIndex)
//        .retrieve()
//        .bodyToMono(FeatureDetails.class)
//        .block();
//  }
//
//
//
//  //UTILS
//  public static Feature transformFeatureDetailsToFeature(FeatureDetails featureDetails) {
//    // On combine toutes les descriptions en une seule chaîne (séparée par des sauts de ligne)
//    String description = String.join("\n", featureDetails.getDesc());
//
//    // Créer et retourner un objet Feature
//    return new Feature(featureDetails.getName(), featureDetails.getLevel(), description);
//  }






}
