package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.dal.repositories.quest.ObjectiveRepository;
import be.storm.rulecrafterbackend.dl.entities.quest.Objective;

public interface ObjectiveService {

    Objective save(Objective objective);
}
