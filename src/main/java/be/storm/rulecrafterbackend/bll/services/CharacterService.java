package be.storm.rulecrafterbackend.bll.services;
import be.storm.rulecrafterbackend.dl.entities.character.Character;
import java.util.List;

public interface CharacterService {
  Character findById(Long id);

  List<Character> findAll();

  Character createCharacter(Character character);
}
