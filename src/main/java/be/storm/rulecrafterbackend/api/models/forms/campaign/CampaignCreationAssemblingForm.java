package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.api.models.dtos.location.*;
import be.storm.rulecrafterbackend.dl.entities.campaign.*;
import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;
import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;

import java.util.List;

public record CampaignCreationAssemblingForm(
        CampaignDTO campaign,
        List<FactionDTO>factions,
        List<LocationDTO> locations,
        MainQuestDTO mainQuest,
        List<SideQuestDTO> sideQuests,
        List<NpcDTO> npcs,
        RegionDTO region,
        ScenarioDTO scenarios
) {

}
