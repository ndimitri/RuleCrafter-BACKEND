package be.storm.rulecrafterbackend.dl.entities.campaign;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Region extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String regionName;

    @Column(nullable = false, length = 1000)
    private String regionDescription;

    private String regionPicture;

    public Region(Long id, String regionName, String regionDescription, String regionPicture) {
        super(id);
        this.regionName = regionName;
        this.regionDescription = regionDescription;
        this.regionPicture = regionPicture;
    }
}
