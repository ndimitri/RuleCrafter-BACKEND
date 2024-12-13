package be.storm.rulecrafterbackend.dal.repositories.npc;

import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcRepository extends JpaRepository<Npc, Long> {
}
