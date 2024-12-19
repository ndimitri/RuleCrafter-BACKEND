package be.storm.rulecrafterbackend.bll.services.campaign.impls;

import be.storm.rulecrafterbackend.bll.services.campaign.LocationService;
import be.storm.rulecrafterbackend.dal.repositories.campaign.LocationRepository;
import be.storm.rulecrafterbackend.dl.entities.campaign.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public List<Location> findByCampaignId(Long campaignId) {
        return locationRepository.findByCampaignId(campaignId);
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }
}
