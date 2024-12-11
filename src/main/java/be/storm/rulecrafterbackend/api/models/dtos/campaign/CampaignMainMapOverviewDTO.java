package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import be.storm.rulecrafterbackend.dl.entities.campaign.Location;

public record CampaignMainMapOverviewDTO(
        String campaignName,
        Location locationName,
        Location locationDescription,
        Location locationPicture
) {
//    public static CampaignMainMapOverviewDTO fromMainMapOverview(Campaign campaign, Location location) {
//        return new CampaignMainMapOverviewDTO(
//                campaign.getCampaignName(),
//        );
//    }
}
