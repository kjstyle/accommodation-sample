package kjstyle.accommodation.domain.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * 숙소-시설 관계 엔티니
 *   - 숙소와 시설을 연결해주는 관계테이블
 *   - 숙소와 시설모두 many-to-onne으로 연결되고 lazy임
 *   - own(mappedBy)은 시설만
 */
@Entity
@Table(name = "ACCOMMODATION_AMENITY")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccommodationAmenityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acmd_amenity_no", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acmd_no", nullable = false)
    private AccommodationEntity accommodation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amenity_no", nullable = false)
    private AmenityEntity amenity;

    @Column(nullable = false)
    private boolean isAvailable;  // 해당 숙소에서 사용 가능한지 여부
}