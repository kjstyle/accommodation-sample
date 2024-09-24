package kjstyle.accommodation.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccommodationType {
    HOTEL("HOTEL"), MOTEL("MOTEL");
    private String value;
}
