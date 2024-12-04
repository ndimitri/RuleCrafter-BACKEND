package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.character.CharacterDTO;
import be.storm.rulecrafterbackend.bll.character.ClassType;
import be.storm.rulecrafterbackend.bll.services.CharacterService;
import be.storm.rulecrafterbackend.dal.CharacterRepository;
import be.storm.rulecrafterbackend.dal.DnDRepository;
import be.storm.rulecrafterbackend.dal.models.classResponse.DnDClassResponse;
import be.storm.rulecrafterbackend.dl.entities.character.Character;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

  private final CharacterRepository characterRepository;
  private final DnDRepository dnDRepository;

  @Override
  public CharacterDTO findById(Long id) {

    Character character = characterRepository.findById(id).orElseThrow();

    String classTypeName = character.getClassType();
    ;

    ClassType classType = dnDRepository.getClassResponse(classTypeName);

    return new CharacterDTO(character, classType);
  }
}
