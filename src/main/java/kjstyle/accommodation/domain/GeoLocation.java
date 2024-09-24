package kjstyle.accommodation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeoLocation {
    private double latitude;
    private double longitude;
}
