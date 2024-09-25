package kjstyle.accommodation.domain.exceptions;

public class NotFoundImageException extends RuntimeException {
    public NotFoundImageException() {
        super("이미지가 존재하지 않습니다");
    }
}
