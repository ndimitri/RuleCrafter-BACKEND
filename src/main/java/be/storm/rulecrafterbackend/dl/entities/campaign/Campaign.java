package be.storm.rulecrafterbackend.dl.entities.campaign;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Entity
//@SQLDelete(sql = "update Campaign set is_deleted = true where id = ?")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Campaign extends BaseEntity {


    @Column(nullable = false, length = 123)
    private String campaignName;

    @Column(nullable = false)
    @Range(min = 0)
    private int minCapacity;

    @Column(nullable = false)
    @Range(min = 1, max = 10)
    private int maxCapacity;

    @Column(nullable = false, length = 500)
    private String partyRecommendation;

    @Column(nullable = false, length = 1000)
    private String campaignSummary;

    @Column
    private String pictureWorldOverview;

    @Column
    private String pictureQuestOverview;

    @Column
    private String pictureRules;

    @Column
    private String mainMapPicture;

    @Column
    private String primaryRacePicture;

    @Column
    private String factionsPicture;

    @Column
    private String monstersPicture;

    @Column
    private String timelinePicture;

    @Column(nullable = false)
    private final boolean isDeleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    @OneToOne(fetch = FetchType.LAZY)
    private Scenario scenario;

    @OneToOne(fetch = FetchType.LAZY)
    private MainQuest mainQuest;

    @OneToOne(fetch = FetchType.LAZY)
    private SideQuest sideQuest;

    public Campaign(String campaignName, String campaignSummary, int minCapacity, int maxCapacity, String partyRecommendation,
                    String pictureWorldOverview, String pictureQuestOverview, String pictureRules) {
        this.campaignName = campaignName;
        this.campaignSummary = campaignSummary;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.partyRecommendation = partyRecommendation;
        this.pictureWorldOverview = pictureWorldOverview;
        this.pictureQuestOverview = pictureQuestOverview;
        this.pictureRules = pictureRules;
    }

    public Campaign(String campaignName, String campaignSummary, int minCapacity, int maxCapacity, String partyRecommendation,
                    String pictureWorldOverview, String pictureQuestOverview, String pictureRules, String mainMapPicture,
                    String primaryRacePicture, String factionsPicture, String monstersPicture, String timelinePicture, Region region) {
        this.campaignName = campaignName;
        this.campaignSummary = campaignSummary;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.partyRecommendation = partyRecommendation;
        this.pictureWorldOverview = pictureWorldOverview;
        this.pictureQuestOverview = pictureQuestOverview;
        this.pictureRules = pictureRules;
        this.mainMapPicture = mainMapPicture;
        this.primaryRacePicture = primaryRacePicture;
        this.factionsPicture = factionsPicture;
        this.monstersPicture = monstersPicture;
        this.timelinePicture = timelinePicture;
        this.region = region;
    }

    public Campaign(String campaignName, String campaignSummary, int minCapacity, int maxCapacity, String partyRecommendation) {
        this.campaignName = campaignName;
        this.campaignSummary = campaignSummary;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.partyRecommendation = partyRecommendation;
    }


}
