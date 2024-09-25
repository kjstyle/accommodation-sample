package kjstyle.accommodation.web;

import kjstyle.accommodation.domain.exceptions.NotFoundAccommodationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorRespons> handleException(Exception e) {
        return new ResponseEntity<>(new ErrorRespons("서버가 일시적으로 문제가 발생했습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorRespons> handleException(BadRequestException e) {
        return new ResponseEntity<>(new ErrorRespons(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorRespons> handleException(NotFoundAccommodationException e) {
        return new ResponseEntity<>(new ErrorRespons("숙소를 찾을 수 없습니다"), HttpStatus.BAD_REQUEST);
    }

    @Getter
    @AllArgsConstructor
    static class ErrorRespons {
        private String message;
    }
}
