package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.*;
import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;
import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;

public record CampaignCreationAssemblingForm(
        Campaign campaign,
        Faction faction,
        Location location,
        Region region,
        Scenario scenario,
        Npc npc,
        MainQuest mainQuest,
        SideQuest sideQuest
) {
    public CampaignInfoContainer toCampaignCreationAssemblingForm() {
        return new CampaignInfoContainer(
                campaign,
                faction,
                location,
                region,
                scenario,
                npc,
                mainQuest,
                sideQuest
        );
    }
}
