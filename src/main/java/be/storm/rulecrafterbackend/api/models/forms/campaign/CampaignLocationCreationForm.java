package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.api.validators.annotations.PictureFormat;
import be.storm.rulecrafterbackend.dl.entities.campaign.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public record CampaignLocationCreationForm(
        @NotBlank @Size(max = 123)
        String locationName,
        @NotBlank @Size(max = 1000)
        String locationDescription,
        @PictureFormat
        MultipartFile locationPicture
) {
    public Location toCampaignLocationCreationForm() {
        return new Location(
                locationName,
                locationDescription
        );
    }
}
