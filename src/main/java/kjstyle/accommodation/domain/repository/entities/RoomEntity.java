package kjstyle.accommodation.domain.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalTime;

/**
 * 숙소에 딸린 방 (사실상 방유형)
 *   - 1호실, 2호실..이 아닌 오션뷰, 온돌방, 스위트 등등을 표현
 */
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
    private String roomName;

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

    @Column(name = "acmd_no", nullable = false)
    private long accommodationId;
}