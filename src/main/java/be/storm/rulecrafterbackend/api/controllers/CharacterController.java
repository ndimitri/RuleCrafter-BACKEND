package be.storm.rulecrafterbackend.api.controllers;

import be.storm.rulecrafterbackend.bll.character.Abilities;
import be.storm.rulecrafterbackend.bll.character.CharacterDTO;
import be.storm.rulecrafterbackend.bll.services.CharacterService;
import be.storm.rulecrafterbackend.dl.entities.character.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/character")
public class CharacterController {

  private final CharacterService characterService;


  @GetMapping("/{id}")
  public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Long id) {
    CharacterDTO characterDTO = characterService.findById(id);
    System.out.println(characterDTO);

    return ResponseEntity.ok(characterDTO);

  }

}
