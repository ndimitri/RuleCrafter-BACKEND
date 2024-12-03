package be.storm.rulecrafterbackend.dal.repositories.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
