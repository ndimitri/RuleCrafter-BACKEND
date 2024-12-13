package be.storm.rulecrafterbackend.dl.entities.campaign;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Faction extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String factionName;

    @Column(nullable = false, length = 1000)
    private String factionDescription;

    @Column
    private String factionPicture;

    @ManyToOne(fetch = FetchType.EAGER)
    private Campaign campaign;

    public Faction(Long id, String factionName, String factionDescription, String factionPicture) {
        super(id);
        this.factionName = factionName;
        this.factionDescription= factionDescription;
        this.factionPicture = factionPicture;
    }

    public Faction(String factionName, String factionDescription, String factionPicture) {
        this.factionName = factionName;
        this.factionDescription = factionDescription;
        this.factionPicture = factionPicture;
    }

    public Faction(String factionName, String factionDescription) {
        this.factionName = factionName;
        this.factionDescription = factionDescription;
    }
}
