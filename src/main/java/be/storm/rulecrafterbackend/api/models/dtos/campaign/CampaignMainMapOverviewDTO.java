package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.api.models.dtos.location.LocationDTO;
import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignMainMapOverviewDTO {

    private Long id;
    private String campaignName;
    private List<LocationDTO> locations;

    public CampaignMainMapOverviewDTO(Long id, String campaignName) {
        this.id = id;
        this.campaignName = campaignName;
    }

    public static CampaignMainMapOverviewDTO fromCampaign(Campaign campaign){
        return new CampaignMainMapOverviewDTO(
                campaign.getId(),
                campaign.getCampaignName()
        );
    }
}
