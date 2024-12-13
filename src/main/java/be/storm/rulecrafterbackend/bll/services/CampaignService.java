package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import be.storm.rulecrafterbackend.dl.entities.campaign.Region;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface CampaignService {

    List<Campaign> findAll();
    Campaign findById(Long id);
    Campaign findByCampaignId(Long id);
    Campaign save(Campaign campaign);
}
