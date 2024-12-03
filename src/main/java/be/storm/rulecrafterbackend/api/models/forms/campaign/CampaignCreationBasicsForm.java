package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.api.validators.annotations.PictureFormat;
import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record CampaignCreationBasicsForm(

        @NotBlank(message = "Required field")
        String campaignName,
        @NotBlank(message = "Required field")
        String campaignSummary,
        @Min(0)
        int minCapacity,
        @Max(10)
        int maxCapacity,
        @NotBlank(message = "Required field")
        String partyRecommendation,
        @PictureFormat
        MultipartFile picture,
        Long id
) {

    public Campaign toCampaign() {
        return  new Campaign(
                this.campaignName,
                this.campaignSummary,
                this.minCapacity,
                this.maxCapacity,
                this.partyRecommendation,
                this.picture
        );
    }
}
