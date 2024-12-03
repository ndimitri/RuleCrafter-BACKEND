package be.storm.rulecrafterbackend.dal.repositories.quest;

import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideQuestRepository extends JpaRepository<SideQuest, Long> {
}
