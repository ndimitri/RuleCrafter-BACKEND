package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CampaignSideQuestCreationForm(
        @NotBlank @Size(max = 123)
        String sideQuestName,
        @NotBlank @Size(max = 500)
        String sideQuestGoal,
        @NotBlank @Size(max = 1000)
        String sideQuestDescription,
        @NotBlank @Size(max = 50)
        String sideQuestType,
        @NotBlank @Size(max = 80)
        String sideQuestTrigger,
        @NotBlank @Size(max = 80)
        String sideQuestReward
) {
    public SideQuest toCampaignSideQuestCreationForm() {
        return new SideQuest(
                sideQuestName,
                sideQuestGoal,
                sideQuestDescription,
                sideQuestType,
                sideQuestTrigger,
                sideQuestReward
        );
    }
}
