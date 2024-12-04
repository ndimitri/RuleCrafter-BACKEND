package be.storm.rulecrafterbackend.dl.entities.campaign;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

@Entity
@SQLDelete(sql = "update Campaign set is_deleted = true where id = ?")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true, of = {"campaignName", "minCapacity", "maxCapacity", "partyRecommendation", "campaignSummary"})
@ToString(callSuper = true, of = {"campaignName", "minCapacity", "maxCapacity", "partyRecommendation", "campaignSummary"})
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
    private String campaignSummary;

//    private MultipartFile picture;

    @Column(nullable = false)
    private final boolean isDeleted = false;

    @OneToOne(fetch = FetchType.EAGER)
    private Region region;

    @OneToOne(fetch = FetchType.EAGER)
    private Scenario scenario;

    @OneToOne(fetch = FetchType.EAGER)
    private MainQuest mainQuest;

    @OneToOne(fetch = FetchType.EAGER)
    private SideQuest sideQuest;

    public Campaign(Long id, String campaignName, String campaignSummary, int minCapacity, int maxCapacity) {
        super(id);
        this.campaignName = campaignName;
        this.campaignSummary = campaignSummary;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
    }

    public Campaign(String campaignName, String campaignSummary, int minCapacity, int maxCapacity, String partyRecommendation, MultipartFile picture) {
        this.campaignName = campaignName;
        this.campaignSummary = campaignSummary;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.partyRecommendation = partyRecommendation;
//        this.picture = picture;
    }

    public Campaign(Long id, String campaignName, int minCapacity, int maxCapacity, String partyRecommendation, String summary, MultipartFile picture) {
        super(id);
        this.campaignName = campaignName;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.partyRecommendation = partyRecommendation;
        this.campaignSummary = summary;
//        this.picture = picture;
    }
}
