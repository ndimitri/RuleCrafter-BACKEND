package be.storm.rulecrafterbackend.api.models.dtos.location;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;

public record CampaignDTO(
        long id,
        String campaignName,
        int minCapacity,
        int maxCapacity,
        String partyRecommendation,
        String campaignSummary
) {
    public static CampaignDTO fromCampaign(Campaign campaign) {
        return new CampaignDTO(
                campaign.getId(),
                campaign.getCampaignName(),
                campaign.getMinCapacity(),
                campaign.getMaxCapacity(),
                campaign.getPartyRecommendation(),
                campaign.getCampaignSummary()
        );
    }
}
