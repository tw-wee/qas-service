package tw.wee.qas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleException(BaseException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatus().value(),
                ex.getErrorCode(), ex.getErrorMessage());

        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
}
