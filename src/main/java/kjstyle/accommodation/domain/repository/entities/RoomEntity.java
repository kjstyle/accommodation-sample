package kjstyle.accommodation.domain.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalTime;

@Entity
@Table(name = "ROOM")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_no", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(nullable = false)
    private String rooomName;

    private String description;

    @Column(nullable = false)
    private Integer minOccupancy;

    @Column(nullable = false)
    private Integer maxOccupancy;

    @Column(nullable = false)
    private String bedTypeDescription;  // 예: "퀸 침대 1개, 싱글 침대 2개"

    @Column(nullable = false)
    private int bedCount;  // 총 침대 수

    @Column(nullable = false)
    private LocalTime checkInTime;  // 체크인 시간

    @Column(nullable = false)
    private LocalTime checkOutTime;  // 체크아웃 시간

    @Column(nullable = true, length = 255)
    private String promotionText;  // 예: "초강력특가"

}