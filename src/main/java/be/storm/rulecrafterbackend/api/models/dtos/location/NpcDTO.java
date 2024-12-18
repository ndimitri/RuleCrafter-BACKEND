package be.storm.rulecrafterbackend.api.models.dtos.location;

import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;

public record NpcDTO(
        long id,
        String npcName,
        String npcDescription
) {
    public static NpcDTO fromNpc(Npc npc) {
        return new NpcDTO(
                npc.getId(),
                npc.getNpcName(),
                npc.getNpcDescription()
        );
    }
}
