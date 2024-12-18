package be.storm.rulecrafterbackend.api.models.dtos.location;

import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;

public record MainQuestDTO(
        long id,
        String questName,
        String questGoal,
        String questDescription,
        String questType,
        String questTrigger,
        String questReward
) {
    public static MainQuestDTO fromMainQuest(MainQuest mainQuest) {
        return new MainQuestDTO(
                mainQuest.getId(),
                mainQuest.getQuestName(),
                mainQuest.getQuestGoal(),
                mainQuest.getQuestDescription(),
                mainQuest.getQuestType(),
                mainQuest.getQuestTrigger(),
                mainQuest.getQuestReward()
        );
    }
}
