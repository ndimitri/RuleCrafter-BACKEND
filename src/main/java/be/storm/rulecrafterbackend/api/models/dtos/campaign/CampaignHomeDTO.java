package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;

public record CampaignHomeDTO(
        long id,
        String campaignName,
        int minCapacity,
        int maxCapacity,
        String campaignSummary
) {
    public static CampaignHomeDTO fromCampaign(Campaign campaign) {
        return new CampaignHomeDTO(
                campaign.getId(),
                campaign.getCampaignName(),
                campaign.getMinCapacity(),
                campaign.getMaxCapacity(),
                campaign.getCampaignSummary()
        );
    }
}
