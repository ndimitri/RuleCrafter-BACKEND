package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.api.validators.annotations.PictureFormat;
import be.storm.rulecrafterbackend.dl.entities.campaign.Region;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public record CampaignRegionCreationForm(
        @NotBlank @Size(max = 123)
        String regionName,
        @NotBlank @Size(max = 1000)
        String regionDescription,
        @PictureFormat
        MultipartFile regionPicture
) {

    public Region toCampaignRegionCreation() {
        return new Region(
                regionName,
                regionDescription
        );
    }
}
