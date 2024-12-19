package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;

public record CampaignOverviewDTO(
        Long id,
        String campaignName,
        String campaignSummary,
        int minCapacity,
        int maxCapacity,
        String partyRecommendation,
        String pictureWorldOverview,
        String pictureQuestOverview,
        String pictureRules
) {

    public static CampaignOverviewDTO fromCampaign(Campaign campaign) {
        return new CampaignOverviewDTO(
                campaign.getId(),
                campaign.getCampaignName(),
                campaign.getCampaignSummary(),
                campaign.getMinCapacity(),
                campaign.getMaxCapacity(),
                campaign.getPartyRecommendation(),
                campaign.getPictureWorldOverview(),
                campaign.getPictureQuestOverview(),
                campaign.getPictureRules()
        );
    }
}
