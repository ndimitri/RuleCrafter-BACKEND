package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.services.FactionService;
import be.storm.rulecrafterbackend.dal.repositories.campaign.FactionRepository;
import be.storm.rulecrafterbackend.dl.entities.campaign.Faction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactionServiceImpl implements FactionService {

    private final FactionRepository factionRepository;

    @Override
    public Faction save(Faction faction) {
        return factionRepository.save(faction);
    }

    @Override
    public List<Faction> findByCampaignId(Long campaignId) {
        return factionRepository.findByCampaignId(campaignId);


    }
}
