package be.storm.rulecrafterbackend.bll.services.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;

import java.util.List;

public interface CampaignService {

    List<Campaign> findAll();
    Campaign findById(Long id);
    Campaign findByCampaignId(Long id);
    Campaign save(Campaign campaign);
}
