package be.storm.rulecrafterbackend.bll.services.campaign.impls;

import be.storm.rulecrafterbackend.bll.services.campaign.SideQuestService;
import be.storm.rulecrafterbackend.dal.repositories.quest.SideQuestRepository;
import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SideQuestServiceImpl implements SideQuestService {

    private final SideQuestRepository sideQuestRepository;

    @Override
    public SideQuest save(SideQuest sideQuest) {
        return sideQuestRepository.save(sideQuest);
    }
}
