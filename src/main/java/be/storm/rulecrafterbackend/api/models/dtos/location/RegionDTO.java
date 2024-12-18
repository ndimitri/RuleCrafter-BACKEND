package be.storm.rulecrafterbackend.api.models.dtos.location;

import be.storm.rulecrafterbackend.dl.entities.campaign.Region;

public record RegionDTO(
        long id,
        String regionName,
        String regionDescription
) {

    public static RegionDTO fromRegion(Region region) {
        return new RegionDTO(
                region.getId(),
                region.getRegionName(),
                region.getRegionDescription()
        );
    }
}
