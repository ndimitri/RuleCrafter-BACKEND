package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.dl.entities.quest.Objective;
import be.storm.rulecrafterbackend.dl.entities.quest.Quest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CampaignObjectiveCreationForm(
        @NotBlank @Size(max = 123)
        String objectiveName,
        @NotBlank @Size(max = 1000)
        String objectiveDescription,
        @NotBlank
        Quest quest
) {
    public Objective toCampaignObjectiveCreationForm() {
        return new Objective(
                objectiveName,
                objectiveDescription,
                quest
        );
    }
}
