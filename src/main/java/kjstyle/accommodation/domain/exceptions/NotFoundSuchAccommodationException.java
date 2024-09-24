package kjstyle.accommodation.domain.exceptions;

public class NotFoundSuchAccommodationException extends RuntimeException {

    public NotFoundSuchAccommodationException() {
        super("등록되지 않은 숙소입니다.");
    }
}
