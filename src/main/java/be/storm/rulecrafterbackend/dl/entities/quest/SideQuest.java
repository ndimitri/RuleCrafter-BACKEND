package be.storm.rulecrafterbackend.dl.entities.quest;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class SideQuest extends Quest {

    public SideQuest(Long id, String questName, String questGoal, String questDescription, String questType, String questTrigger, String questReward) {
        super(id, questName, questGoal, questDescription, questType, questTrigger, questReward);
    }
}
