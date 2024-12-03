package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.bll.character.CharacterDTO;
import be.storm.rulecrafterbackend.dl.entities.character.Character;

public interface CharacterService {
  CharacterDTO findById(Long id);



}
