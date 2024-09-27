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
    private String name;  // 예: "에어컨", "냉장고", "테라스"

    @Column(nullable = true)
    private String description;  // 시설에 대한 설명 (예: "전 객실 에어컨 완비")

    @OneToMany(mappedBy = "amenity", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<AccommodationAmenityEntity> accommodationAmenities = new ArrayList<>();
}