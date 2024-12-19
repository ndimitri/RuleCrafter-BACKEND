package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.api.models.dtos.location.FactionDTO;
import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignFactionsOverviewDTO {

    private Long id;
    private String campaignName;
    private List<FactionDTO> factions;

    public CampaignFactionsOverviewDTO(Long id, String campaignName) {
        this.id = id;
        this.campaignName = campaignName;
    }

    public static CampaignFactionsOverviewDTO fromCampaign(Campaign campaign) {
        return new CampaignFactionsOverviewDTO(
                campaign.getId(),
                campaign.getCampaignName()
        );
    }
}
