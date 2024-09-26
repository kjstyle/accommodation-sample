package kjstyle.accommodation.domain.repository.entities;

import jakarta.persistence.*;
import kjstyle.accommodation.domain.enums.ImageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "image")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_no", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImageType imageType;

    @Column(nullable = false)
    private String path;

    @Column(name = "acmd_no", nullable = false)
    private long accommodationId;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "acmd_no", nullable = false)
//    private AccommodationEntity accommodation;
}