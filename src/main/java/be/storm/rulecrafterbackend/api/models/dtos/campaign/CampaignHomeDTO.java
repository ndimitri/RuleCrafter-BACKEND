package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;

public record CampaignHomeDTO(
        long id,
        String campaignName,
        String campaignSummary,
        int minCapacity,
        int maxCapacity
) {

    public static CampaignHomeDTO fromCampaign(Campaign campaign) {
        return new CampaignHomeDTO(
                campaign.getId(),
                campaign.getCampaignName(),
                campaign.getCampaignSummary(),
                campaign.getMinCapacity(),
                campaign.getMaxCapacity()
        );
    }
}
