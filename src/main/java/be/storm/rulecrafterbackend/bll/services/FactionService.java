package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.dl.entities.campaign.Faction;

import java.util.List;

public interface FactionService {

    List<Faction> findByCampaignId(Long campaignId);
}
