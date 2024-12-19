package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Scenario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CampaignScenarioCreationForm(
        @NotBlank @Size(max = 123)
        String storyName,
        @NotBlank @Size(max = 100_000)
        String story
) {
    public Scenario toCampaignScenarioCreationForm() {
        return new Scenario(
                story,
                storyName
        );
    }
}
