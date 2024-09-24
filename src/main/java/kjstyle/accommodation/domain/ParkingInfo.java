package kjstyle.accommodation.domain;

import kjstyle.accommodation.domain.enums.ParkingType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParkingInfo {
    private boolean isFree;
    private ParkingType parkingType;
}
