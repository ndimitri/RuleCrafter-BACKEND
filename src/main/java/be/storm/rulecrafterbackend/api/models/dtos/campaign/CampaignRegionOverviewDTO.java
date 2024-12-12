package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;

public record CampaignRegionOverviewDTO(
        long id,
        String campaignName,
        String regionName,
        String regionDescription,
        String regionPicture
) {
    public static CampaignRegionOverviewDTO fromCampaignRegion(Campaign campaign) {
        return new CampaignRegionOverviewDTO(
                campaign.getId(),
                campaign.getCampaignName(),
                campaign.getRegion().getRegionName(),
                campaign.getRegion().getRegionDescription(),
                campaign.getRegion().getRegionPicture()
        );
    }
}
