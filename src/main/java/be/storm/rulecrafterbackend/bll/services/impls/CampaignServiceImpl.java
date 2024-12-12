package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.services.CampaignService;
import be.storm.rulecrafterbackend.dal.repositories.campaign.CampaignRepository;
import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import be.storm.rulecrafterbackend.dl.entities.campaign.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {


    private final CampaignRepository campaignRepository;

    @Override
    public List<Campaign> findAll() {
        return campaignRepository.findAllActive();
    }

    @Override
    public Campaign findById(Long id) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow();
        if(campaign.isDeleted()) {
            throw new RuntimeException("Campaign deleted");
        }
        return campaign;
    }

    @Override
    public List<Region> findByRegionId(Long regionId) {
        return campaignRepository.findByRegionId(regionId);
    }
}
