package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.services.CampaignInfoContainerService;
import be.storm.rulecrafterbackend.dal.repositories.campaign.CampaignInfoContainerRepository;
import be.storm.rulecrafterbackend.dl.entities.campaign.CampaignInfoContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignInfoContainerServiceImpl implements CampaignInfoContainerService {

    private final CampaignInfoContainerRepository campaignInfoContainerRepository;

    @Override
    public CampaignInfoContainer save(CampaignInfoContainer campaignInfoContainer) {
        return campaignInfoContainerRepository.save(campaignInfoContainer);
    }

    @Override
    public List<CampaignInfoContainer> findAll() {
        return campaignInfoContainerRepository.findAll();
    }
}
