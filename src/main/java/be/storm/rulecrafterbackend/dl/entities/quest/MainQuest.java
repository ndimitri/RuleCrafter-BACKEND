package be.storm.rulecrafterbackend.dl.entities.quest;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class MainQuest extends Quest {

    public MainQuest(Long id, String questName, String questGoal, String questDescription, String questType, String questTrigger,
                     String questReward) {
        super(id, questName, questGoal, questDescription, questType, questTrigger, questReward);
    }

    public MainQuest(String questName, String questGoal, String questDescription, String questType, String questTrigger,
                     String questReward) {
        super(questName, questGoal, questDescription, questType, questTrigger, questReward);
    }
}
