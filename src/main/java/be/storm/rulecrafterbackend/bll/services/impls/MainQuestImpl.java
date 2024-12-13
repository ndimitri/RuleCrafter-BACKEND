package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.services.MainQuestService;
import be.storm.rulecrafterbackend.dal.repositories.quest.MainQuestRepository;
import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainQuestImpl implements MainQuestService {

    private MainQuestRepository mainQuestRepository;

    @Override
    public MainQuest save(MainQuest mainQuest) {
        return mainQuestRepository.save(mainQuest);
    }
}
