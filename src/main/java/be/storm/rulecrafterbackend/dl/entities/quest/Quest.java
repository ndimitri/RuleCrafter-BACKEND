package be.storm.rulecrafterbackend.dl.entities.quest;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public abstract class Quest extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String questName;

    @Column(nullable = false, length = 500)
    private String questGoal;

    @Column(nullable = false, length = 1000)
    private String questDescription;

    @Column(nullable = false, length = 50)
    private String questType;

    @Column(nullable = false, length = 80)
    private String questTrigger;

    @Column(nullable = false)
    private String questReward;

    public Quest(Long id, String questName, String questGoal, String questDescription, String questType, String questTrigger, String questReward) {
        super(id);
        this.questName = questName;
        this.questGoal = questGoal;
        this.questDescription = questDescription;
        this.questType = questType;
        this.questTrigger = questTrigger;
        this.questReward = questReward;
    }
}
