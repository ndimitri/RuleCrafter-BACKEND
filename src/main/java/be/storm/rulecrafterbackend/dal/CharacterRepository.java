package be.storm.rulecrafterbackend.dal;

import be.storm.rulecrafterbackend.dl.entities.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}
