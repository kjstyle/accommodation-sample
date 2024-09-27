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
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "amenity", cascade = CascadeType.ALL, orphanRemoval = false)
    @Builder.Default // warning이 떠서 보니... @Builder랑 쫑나서.. builder한테 필드변수 초기화 그냥 유지해..옵션을 추가
    private List<AccommodationAmenityEntity> accommodationAmenities = new ArrayList<>();
}