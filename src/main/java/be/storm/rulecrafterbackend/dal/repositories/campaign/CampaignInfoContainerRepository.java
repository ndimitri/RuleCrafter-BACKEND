package be.storm.rulecrafterbackend.dal.repositories.campaign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignInfoContainerRepository extends JpaRepository<be.storm.rulecrafterbackend.dl.entities.campaign.CampaignInfoContainer, Long> {
}
