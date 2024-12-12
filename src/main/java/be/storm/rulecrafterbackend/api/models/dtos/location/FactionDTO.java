package be.storm.rulecrafterbackend.api.models.dtos.location;

import be.storm.rulecrafterbackend.dl.entities.campaign.Faction;

public record FactionDTO(
        long id,
        String factionName,
        String factionDescription,
        String factionPicture
) {
    public static FactionDTO fromFaction(Faction faction) {
        return new FactionDTO(
                faction.getId(),
                faction.getFactionName(),
                faction.getFactionDescription(),
                faction.getFactionPicture()
        );
    }
}
