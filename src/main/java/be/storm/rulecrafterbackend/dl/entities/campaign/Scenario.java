package be.storm.rulecrafterbackend.dl.entities.campaign;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Scenario extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String storyName;

    @Column(nullable = false, length = 100_000)
    private String story;

    public Scenario(String story) {
        this.story = story;
    }

    public Scenario(String storyName, String story) {
        this.storyName = storyName;
        this.story = story;
    }
}
