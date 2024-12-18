package be.storm.rulecrafterbackend.api.models.dtos.location;

import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;

public record SideQuestDTO(
        long id,
        String sideQuestName,
        String sideQuestGoal,
        String sideQuestDescription,
        String sideQuestType,
        String sideQuestTrigger,
        String sideQuestReward
) {
    public static SideQuestDTO fromSideQuest(SideQuest sideQuest) {
        return new SideQuestDTO(
                sideQuest.getId(),
                sideQuest.getQuestName(),
                sideQuest.getQuestGoal(),
                sideQuest.getQuestDescription(),
                sideQuest.getQuestType(),
                sideQuest.getQuestTrigger(),
                sideQuest.getQuestReward()
        );
    }
}
