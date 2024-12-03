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
public class Location extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String locationName;

    @Column(nullable = false, length = 1000)
    private String locationDescription;

    private String locationPicture;

    @ManyToOne(fetch = FetchType.EAGER)
    private Campaign campaign;

    public Location(Long id, String locationName, String locationDescription, String locationPicture) {
        super(id);
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.locationPicture = locationPicture;
    }
}
