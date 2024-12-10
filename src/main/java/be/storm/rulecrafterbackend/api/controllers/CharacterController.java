package be.storm.rulecrafterbackend.api.controllers;
import be.storm.rulecrafterbackend.api.dtos.CharacterDTO;
import be.storm.rulecrafterbackend.bll.services.CharacterService;
import be.storm.rulecrafterbackend.dl.entities.character.Character;
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


  @GetMapping
  public ResponseEntity<List<CharacterDTO>> getCharacters() {
    List<Character> characters = characterService.findAll();
    List<CharacterDTO> characterDTOs = characters.stream().map(CharacterDTO::fromCharacter).toList();

    return ResponseEntity.ok(characterDTOs);
  }


  @GetMapping("/{id}")
  public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Long id) {
    Character character = characterService.findById(id);
    CharacterDTO characterDTO = CharacterDTO.fromCharacter(character);

    return ResponseEntity.ok(characterDTO);

  }

}
