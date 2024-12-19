package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import be.storm.rulecrafterbackend.dl.entities.campaign.Faction;

public record CampaignWorldOverviewDTO(
        Long id,
        String campaignName,
        String mainMapPicture,
        String primaryRacePicture,
        String factionsPicture,
        String monstersPicture,
        String timelinePicture
) {
    public static CampaignWorldOverviewDTO fromWorldOverview(Campaign campaign) {
        return new CampaignWorldOverviewDTO(
                campaign.getId(),
                campaign.getCampaignName(),
                campaign.getMainMapPicture(),
                campaign.getPrimaryRacePicture(),
                campaign.getFactionsPicture(),
                campaign.getMonstersPicture(),
                campaign.getTimelinePicture()
        );
    }
}
