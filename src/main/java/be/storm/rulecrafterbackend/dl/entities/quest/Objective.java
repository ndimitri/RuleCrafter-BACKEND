package be.storm.rulecrafterbackend.dl.entities.quest;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Objective extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String objectiveName;

    @Column(nullable = false)
    private boolean optional;

    @Column(nullable = false)
    private String objectiveDescription;

    @OneToOne(fetch = FetchType.EAGER)
    private Quest quest;

    public Objective(Long id, String objectiveName, boolean optional, String objectiveDescription) {
        super(id);
        this.objectiveName = objectiveName;
        this.optional = optional;
        this.objectiveDescription = objectiveDescription;
    }
}
