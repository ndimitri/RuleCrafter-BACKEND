package be.storm.rulecrafterbackend.bll.services.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Faction;

import java.util.List;

public interface FactionService {

    List<Faction> findByCampaignId(Long campaignId);
    Faction save(Faction faction);
}
