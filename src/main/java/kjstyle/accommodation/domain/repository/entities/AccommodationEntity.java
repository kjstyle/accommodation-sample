package kjstyle.accommodation.domain.repository.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "ACCOMMODATION")
@Getter
public class AccommodationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "acmd_no", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    private String name;
    private String description;
    private double latitude;
    private double longitude;
    private String type;
    private boolean isFreeParking;
    private String parkingType;
    private String locationGuideText;
    private long imageNo;
}
