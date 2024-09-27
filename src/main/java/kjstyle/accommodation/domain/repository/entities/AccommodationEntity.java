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

import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = true)
    private boolean isFreeParking;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ParkingType parkingType;

    @Column(nullable = true)
    private String locationGuideText;

//    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, orphanRemoval = true)
//    @Column(nullable = false)
//    private List<ImageEntity> images = new ArrayList<>();

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccommodationAmenityEntity> accommodationAmenityList = new ArrayList<>();
}