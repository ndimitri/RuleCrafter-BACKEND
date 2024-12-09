package be.storm.rulecrafterbackend.api.controllers;
import be.storm.rulecrafterbackend.api.dtos.CharacterFullDTO;
import be.storm.rulecrafterbackend.bll.character.CharacterDTO;
import be.storm.rulecrafterbackend.bll.services.CharacterFullService;
import be.storm.rulecrafterbackend.bll.services.CharacterService;
import be.storm.rulecrafterbackend.dl.entities.character.Character;
import be.storm.rulecrafterbackend.dl.entities.character.CharacterFull;
import java.util.List;
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
  private final CharacterFullService characterFullService;


//  @GetMapping("/{id}")
//  public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Long id) {
//    CharacterDTO characterDTO = characterService.findById(id);
//    System.out.println(characterDTO);
//
//    return ResponseEntity.ok(characterDTO);
//
//  }


  @GetMapping
  public ResponseEntity<List<CharacterFullDTO>> getCharacters() {
    List<CharacterFull> characters = characterFullService.getAllCharacters();
    List<CharacterFullDTO> characterFullDTOs = characters.stream().map(CharacterFullDTO::fromCharacterFull).toList();

    return ResponseEntity.ok(characterFullDTOs);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CharacterFullDTO> getCharacterById(@PathVariable Long id) {
    CharacterFull character = characterFullService.getCharacterById(id).orElseThrow();
    CharacterFullDTO characterFullDTO = CharacterFullDTO.fromCharacterFull(character);
    System.out.println(character);

    return ResponseEntity.ok(characterFullDTO);

  }

}
