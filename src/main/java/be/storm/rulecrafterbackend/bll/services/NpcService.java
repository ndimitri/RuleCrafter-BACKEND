package be.storm.rulecrafterbackend.bll.services;

import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;
import org.springframework.stereotype.Service;

public interface NpcService {

    Npc save(Npc npc);
}
