package be.storm.rulecrafterbackend.dal.repositories.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
