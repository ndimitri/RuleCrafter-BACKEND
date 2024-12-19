package be.storm.rulecrafterbackend.dal.repositories.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("select l from Location l join l.campaign c where c.id = :campaignId")
    List<Location> findByCampaignId(Long campaignId);
}
