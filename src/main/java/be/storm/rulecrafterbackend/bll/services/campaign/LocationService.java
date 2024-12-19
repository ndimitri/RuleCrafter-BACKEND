package be.storm.rulecrafterbackend.bll.services.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Location;

import java.util.List;

public interface LocationService {

    List<Location> findByCampaignId(Long campaignId);
    Location save(Location location);
}
