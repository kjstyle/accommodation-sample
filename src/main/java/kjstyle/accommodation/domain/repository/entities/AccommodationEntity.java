package kjstyle.accommodation.domain.repository.entities;

import jakarta.persistence.*;
import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.enums.ParkingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * 숙소 엔티티
 *   - 가장 많이 사용될 녀석이라 이 엔티티에는 연관관계를 걸지 않을 예정
 */
@Entity
@Table(name = "ACCOMMODATION")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccommodationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acmd_no", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    private double latitude;
    private double longitude;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccommodationType type;

    @Column(nullable = false)
    private boolean isFreeParking;

    @Enumerated(EnumType.STRING)
    private ParkingType parkingType;

    private String locationGuideText;
}