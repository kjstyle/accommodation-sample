package kjstyle.accommodation.domain.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * 시설 엔티티
 *   - 예를들어 에어컨, 냉장고, TV 등이 있고
 *   - 숙소에 종속된 속성으로
 *   - 관계테이블을 통해 숙소와 시설은 사실상 다대다 관계
 *   - 숙소에 딸린 시설들이 뭐지?의 요건이 대부분일 거라 -> 주인을 시설로 두고, 숙소키를 가지고 시설들을 조회하도록 연관관계를 구성함
 */
@Entity
@Table(name = "AMENITY")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmenityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenity_no", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "amenity", cascade = CascadeType.ALL, orphanRemoval = false)
    @Builder.Default // warning이 떠서 보니... @Builder랑 쫑나서.. builder한테 필드변수 초기화 그냥 유지해..옵션을 추가
    private List<AccommodationAmenityEntity> accommodationAmenities = new ArrayList<>();
}