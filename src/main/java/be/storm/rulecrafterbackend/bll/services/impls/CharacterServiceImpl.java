package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.services.CharacterService;
import be.storm.rulecrafterbackend.dal.CharacterRepository;
import be.storm.rulecrafterbackend.dl.entities.character.Character;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
  private final CharacterRepository characterRepository;

  @Override
  public Character findById(Long id) {
    return characterRepository.findById(id).orElseThrow();
  }

  @Override
  public List<Character> findAll() {
    return characterRepository.findAll();
  }

  @Override
  public Character createCharacter(Character character) {
    return characterRepository.save(character);
  }
}
