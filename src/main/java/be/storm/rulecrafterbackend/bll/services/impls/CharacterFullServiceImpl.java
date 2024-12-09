package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.services.CharacterFullService;
import be.storm.rulecrafterbackend.dal.CharacterFullRepository;
import be.storm.rulecrafterbackend.dal.CharacterRepository;
import be.storm.rulecrafterbackend.dl.entities.character.CharacterFull;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterFullServiceImpl implements CharacterFullService {

  private final CharacterFullRepository characterFullRepository;

  @Override
  public List<CharacterFull> getAllCharacters() {
    return characterFullRepository.findAll();
  }

  @Override
  public Optional<CharacterFull> getCharacterById(Long id) {
    return characterFullRepository.findById(id);
  }

  @Override
  public CharacterFull createCharacter(CharacterFull character) {
    return characterFullRepository.save(character);
  }

  @Override
  public CharacterFull updateCharacter(Long id, CharacterFull updatedCharacter) {
    return characterFullRepository.findById(id).map(characterFull -> {
      updatedCharacter.setId(characterFull.getId());
      return characterFullRepository.save(updatedCharacter);
    }).orElseThrow(()-> new RuntimeException("Character not found"));
  }

  @Override
  public void deleteCharacter(Long id) {
    characterFullRepository.deleteById(id);
  }
}
