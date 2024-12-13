package be.storm.rulecrafterbackend.bll.services.impls;

import be.storm.rulecrafterbackend.bll.services.NpcService;
import be.storm.rulecrafterbackend.dal.repositories.npc.NpcRepository;
import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NpcServiceImpl implements NpcService {

    private final NpcRepository npcRepository;

    @Override
    public Npc save(Npc npc) {
        return npcRepository.save(npc);
    }
}
