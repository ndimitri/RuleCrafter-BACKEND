package be.storm.rulecrafterbackend.bll.services.campaign.impls;

import be.storm.rulecrafterbackend.bll.services.campaign.ObjectiveService;
import be.storm.rulecrafterbackend.dal.repositories.quest.ObjectiveRepository;
import be.storm.rulecrafterbackend.dl.entities.quest.Objective;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObjectiveServiceImpl implements ObjectiveService {

    private final ObjectiveRepository objectiveRepository;

    @Override
    public Objective save(Objective objective) {
        return objectiveRepository.save(objective);
    }
}
