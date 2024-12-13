package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CampaignBasicsInfoCreationForm(
        @NotBlank @Size(max = 100)
        String campaignName,
        @NotBlank @Size(max = 1000)
        String campaignSummary,
        @NotNull @Min(0)
        int minCapacity,
        @NotNull @Min(1)
        int maxCapacity,
        @NotBlank @Size(max = 500)
        String partyRecommendation
) {
    public Campaign toCampaignBasicsInfo() {
        return new Campaign(campaignName, campaignSummary, minCapacity, maxCapacity, partyRecommendation);
    }
}
