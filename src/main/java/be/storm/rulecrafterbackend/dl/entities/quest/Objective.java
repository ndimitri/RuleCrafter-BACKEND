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
    private String objectiveDescription;

    @OneToOne(fetch = FetchType.EAGER)
    private Quest quest;

    public Objective(Long id, String objectiveName, String objectiveDescription) {
        super(id);
        this.objectiveName = objectiveName;
        this.objectiveDescription = objectiveDescription;
    }

    public Objective(String objectiveName, String objectiveDescription, Quest quest) {
        this.objectiveName = objectiveName;
        this.objectiveDescription = objectiveDescription;
        this.quest = quest;
    }
}
