package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CampaignService {

    Campaign save(Campaign campaign, MultipartFile picture);
}
