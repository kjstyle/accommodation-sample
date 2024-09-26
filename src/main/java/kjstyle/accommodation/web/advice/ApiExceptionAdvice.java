package kjstyle.accommodation.web.advice;

import kjstyle.accommodation.domain.exceptions.NotFoundAccommodationException;
import kjstyle.accommodation.web.dto.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ApiExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundAccommodationException.class)
    public ResponseEntity<ErrorResponse> handleException(NotFoundAccommodationException e) {
        return new ResponseEntity<>(new ErrorResponse("숙소를 찾을 수 없습니다"), HttpStatus.BAD_REQUEST);
    }
}
