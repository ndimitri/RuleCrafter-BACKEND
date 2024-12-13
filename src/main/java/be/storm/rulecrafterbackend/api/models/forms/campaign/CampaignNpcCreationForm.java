package be.storm.rulecrafterbackend.api.models.forms.campaign;

import be.storm.rulecrafterbackend.dl.entities.campaign.Location;
import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CampaignNpcCreationForm(
        @NotBlank @Size(max = 123)
        String npcName,
        @NotBlank @Size(max = 1000)
        String npcDescription,
        @NotBlank
        Location location
) {
    public Npc toCampaignNpcCreationForm() {
        return new Npc(
                npcName,
                npcDescription
        );
    }
}
