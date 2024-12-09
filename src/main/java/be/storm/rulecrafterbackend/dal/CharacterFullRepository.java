package be.storm.rulecrafterbackend.dal;

import be.storm.rulecrafterbackend.dl.entities.character.CharacterFull;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterFullRepository extends JpaRepository<CharacterFull, Long> {

}
