package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.dl.entities.campaign.CampaignInfoContainer;

import java.util.List;

public interface CampaignInfoContainerService {

    CampaignInfoContainer save(CampaignInfoContainer campaignInfoContainer);
    List<CampaignInfoContainer> findAll();
}
