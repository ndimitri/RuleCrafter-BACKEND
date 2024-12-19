package be.storm.rulecrafterbackend.bll.services.campaign.impls;

import be.storm.rulecrafterbackend.bll.services.campaign.CampaignService;
import be.storm.rulecrafterbackend.dal.repositories.campaign.CampaignRepository;
import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Campaign findByCampaignId(Long id) {
        Campaign campaign = campaignRepository.findByCampaignId(id).orElseThrow();
        return campaign;
    }

    @Override
    public Campaign save(Campaign campaign) {
        return campaignRepository.save(campaign);
    }
}
