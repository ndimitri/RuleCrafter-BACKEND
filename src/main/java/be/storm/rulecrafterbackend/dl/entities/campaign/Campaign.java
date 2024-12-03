package be.storm.rulecrafterbackend.dl.entities.campaign;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Campaign extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String campaignName;

    @Column(nullable = false)
    @Range(min = 0)
    private int minCapacity;

    @Column(nullable = false)
    @Range(min = 0, max = 10)
    private int maxCapacity;

    @Column(nullable = false, length = 500)
    private String partyRecommendation;

    @Column(nullable = false, length = 1000)
    private String summary;

    private String picture;

    @OneToOne(fetch = FetchType.EAGER)
    private Region region;

    @OneToOne(fetch = FetchType.EAGER)
    private Scenario scenario;

    @OneToOne(fetch = FetchType.EAGER)
    private MainQuest mainQuest;

    @OneToOne(fetch = FetchType.EAGER)
    private SideQuest sideQuest;

    public Campaign(Long id, String campaignName, int minCapacity, int maxCapacity, String partyRecommendation, String summary, String picture) {
        super(id);
        this.campaignName = campaignName;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.partyRecommendation = partyRecommendation;
        this.summary = summary;
        this.picture = picture;
    }
}
