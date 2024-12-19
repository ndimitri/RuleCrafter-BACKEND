package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CampaignMainQuestCreationForm(
        @NotBlank @Size(max = 123)
        String questName,
        @NotBlank @Size(max = 500)
        String questGoal,
        @NotBlank @Size(max = 1000)
        String questDescription,
        @NotBlank @Size(max = 50)
        String questType,
        @NotBlank @Size(max = 80)
        String questTrigger,
        @NotBlank @Size(max = 80)
        String questReward
) {
    public MainQuest toCampaignMainQuestCreationForm() {
        return new MainQuest(
                questName,
                questGoal,
                questDescription,
                questType,
                questTrigger,
                questReward
        );
    }
}
