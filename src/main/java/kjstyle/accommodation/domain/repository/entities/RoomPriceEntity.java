package kjstyle.accommodation.domain.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ROOM_PRICE")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomPriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_price_no", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_no", nullable = false)
    private RoomEntity room;  // 어느 방의 가격인지

    @Column(nullable = false)
    private LocalDate priceDate;  // 가격이 적용되는 날짜

    @Column(nullable = false)
    private BigDecimal price;  // 해당 날짜의 가격

    // 추가: 할인가, 이벤트 여부 등도 넣을 수 있음
    @Column
    private BigDecimal discountPrice;  // 할인가 (optional)

    @Column
    private boolean isPromotional;  // 프로모션 여부
}