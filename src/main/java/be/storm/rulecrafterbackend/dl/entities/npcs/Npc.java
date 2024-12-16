package be.storm.rulecrafterbackend.dl.entities.npcs;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jdk.jfr.Enabled;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Npc extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String npcName;

    @Column(nullable = false, length = 1000)
    private String npcDescription;

    public Npc(String npcName, String npcDescription) {
        this.npcName = npcName;
        this.npcDescription = npcDescription;
    }


}
