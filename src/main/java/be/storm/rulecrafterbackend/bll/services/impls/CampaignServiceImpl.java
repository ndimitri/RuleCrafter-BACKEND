package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.services.CampaignService;
import be.storm.rulecrafterbackend.dal.repositories.campaign.CampaignRepository;
import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
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
    public Campaign save(Campaign campaign, MultipartFile picture) {

        if (picture != null && !picture.isEmpty()) {
//            campaign.setPicture(savePicture(picture));
        }
        return campaignRepository.save(campaign);
    }

    private String savePicture(MultipartFile picture) {

        String pictureName = (UUID.randomUUID() + "_" + picture.getOriginalFilename());
        Path picturePath = Path.of(System.getProperty("user.dir"), "pictures", pictureName);
        try {
            Files.write(picturePath, picture.getBytes());
            return pictureName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
