package be.storm.rulecrafterbackend.dl.entities.campaign;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@NoArgsConstructor
@Getter
public class Campaign extends BaseEntity {

    @Setter
    @Column(nullable = false, length = 123)
    private String name;

    @Setter
    @Column(nullable = false, length = 350)
    private String summary;
}
