package kjstyle.accommodation.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccommodationStatus {
    AVALIABLE("AVAILABLE"), HOLDING("HOLDING"), DELETED("DELETED");
    private String status;
}
