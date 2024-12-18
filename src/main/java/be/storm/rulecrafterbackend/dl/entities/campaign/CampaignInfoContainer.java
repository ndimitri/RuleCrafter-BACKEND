package be.storm.rulecrafterbackend.dl.entities.campaign;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;
import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
@NoArgsConstructor
public class CampaignInfoContainer extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    private Campaign campaign;

    @ManyToOne(fetch = FetchType.EAGER)
    private Faction faction;

    @ManyToOne(fetch = FetchType.EAGER)
    private Location location;

    @ManyToOne(fetch = FetchType.EAGER)
    private Region region;

    @OneToOne(fetch = FetchType.EAGER)
    private Scenario scenario;

    @ManyToOne(fetch = FetchType.EAGER)
    private Npc npc;

    @ManyToOne(fetch = FetchType.EAGER)
    private MainQuest mainQuest;

    @ManyToOne(fetch = FetchType.EAGER)
    private SideQuest sideQuest;

    public CampaignInfoContainer(Campaign campaign, Faction faction, Location location, Region region, Scenario scenario, Npc npc, MainQuest mainQuest, SideQuest sideQuest) {
        this.campaign = campaign;
        this.faction = faction;
        this.location = location;
        this.region = region;
        this.scenario = scenario;
        this.npc = npc;
        this.mainQuest = mainQuest;
        this.sideQuest = sideQuest;
    }

    public CampaignInfoContainer(Long id, Campaign campaign, Faction faction, Location location, Region region, Scenario scenario, Npc npc, MainQuest mainQuest, SideQuest sideQuest) {
        super(id);
        this.campaign = campaign;
        this.faction = faction;
        this.location = location;
        this.region = region;
        this.scenario = scenario;
        this.npc = npc;
        this.mainQuest = mainQuest;
        this.sideQuest = sideQuest;
    }
}
