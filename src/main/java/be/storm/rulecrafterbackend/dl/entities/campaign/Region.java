package be.storm.rulecrafterbackend.dl.entities.campaign;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Region extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String regionName;

    @Column(nullable = false, length = 1000)
    private String regionDescription;

    private String regionPicture;

    public Region(String regionName, String regionDescription, String regionPicture) {
        this.regionName = regionName;
        this.regionDescription = regionDescription;
        this.regionPicture = regionPicture;
    }

    public Region(String regionName, String regionDescription) {
        this.regionName = regionName;
        this.regionDescription = regionDescription;
    }
}
