package be.storm.rulecrafterbackend.dal.repositories.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    @Query("select c from Campaign c where c.isDeleted = false")
    List<Campaign> findAllActive();
}
