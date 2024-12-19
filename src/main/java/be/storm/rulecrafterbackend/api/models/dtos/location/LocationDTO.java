package be.storm.rulecrafterbackend.api.models.dtos.location;

import be.storm.rulecrafterbackend.dl.entities.campaign.Location;

public record LocationDTO(
        long id,
        String locationName,
        String locationDescription,
        String locationPicture
) {
    public static LocationDTO fromLocation(Location location) {
        return new LocationDTO(
                location.getId(),
                location.getLocationName(),
                location.getLocationPicture(),
                location.getLocationDescription()
        );
    }
}
