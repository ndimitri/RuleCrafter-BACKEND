package be.storm.rulecrafterbackend.api.models.dtos.location;

import be.storm.rulecrafterbackend.dl.entities.campaign.Scenario;

public record ScenarioDTO(
        long id,
        String storyName,
        String story
) {
    public static ScenarioDTO fromScenario(Scenario scenario) {
        return new ScenarioDTO(
                scenario.getId(),
                scenario.getStoryName(),
                scenario.getStory()
        );
    }
}
