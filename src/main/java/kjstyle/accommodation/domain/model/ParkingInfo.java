package kjstyle.accommodation.domain.model;

import kjstyle.accommodation.domain.enums.ParkingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor // 스프링캐시에 넣으려면 Deserialization할 때 NoArgsConstructor가 있거나 setter가 있어야하는데..여튼 어쩔 수 없이 추가
public class ParkingInfo {
    private Boolean isFree;
    private ParkingType parkingType;
}
