package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.api.validators.annotations.PictureFormat;
import be.storm.rulecrafterbackend.dl.entities.campaign.Faction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public record CampaignFactionCreationForm(
        @NotBlank @Size(max = 123)
        String factionName,
        @NotBlank @Size(max = 1000)
        String factionDescription,
        @PictureFormat
        MultipartFile factionPicture
) {
    public Faction toCampaignFactionCreationForm() {
        return new Faction(
                factionName,
                factionDescription
        );
    };
}
