package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.api.models.dtos.location.*;
import be.storm.rulecrafterbackend.dl.entities.campaign.*;
import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;
import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignCreationAssemblingDTO {

    private Long id;
    private List<CampaignDTO> campaigns;
    private List<FactionDTO> factions;
    private List<LocationDTO> locations;
    private List<MainQuestDTO> mainQuests;
    private List<SideQuestDTO> sideQuests;
    private List<NpcDTO> npcs;
    private List<RegionDTO> regions;
    private List<ScenarioDTO> scenarios;

    public CampaignCreationAssemblingDTO(Long id) {
        this.id = id;
    }

    public static CampaignCreationAssemblingDTO fromCampaignCreationAssemblingDTO(CampaignInfoContainer campaignInfoContainer) {
        return new CampaignCreationAssemblingDTO(
                campaignInfoContainer.getId()
        );
    }
}
