package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.services.ScenarioService;
import be.storm.rulecrafterbackend.dal.repositories.campaign.ScenarioRepository;
import be.storm.rulecrafterbackend.dl.entities.campaign.Scenario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScenarioServiceImpl implements ScenarioService {

    private final ScenarioRepository scenarioRepository;

    @Override
    public Scenario save(Scenario scenario) {
        return scenarioRepository.save(scenario);
    }
}
