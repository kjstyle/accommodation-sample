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

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    private double latitude;
    private double longitude;

    @Column(nullable = false, length = 10)
    private String type;

    private boolean isFreeParking;
    private String parkingType;

    private String locationGuideText;

    @Column(nullable = false)
    private long imageNo;
}
