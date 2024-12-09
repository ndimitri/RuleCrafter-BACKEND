package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.dl.entities.character.CharacterFull;
import java.util.List;
import java.util.Optional;

public interface CharacterFullService {

  public List<CharacterFull> getAllCharacters();

  public Optional<CharacterFull> getCharacterById(Long id);

  public CharacterFull createCharacter(CharacterFull character);

  public CharacterFull updateCharacter(Long id, CharacterFull updatedCharacter);

  public void deleteCharacter(Long id);
}
