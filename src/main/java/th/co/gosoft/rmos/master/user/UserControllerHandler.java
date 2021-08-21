package th.co.gosoft.rmos.master.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import th.co.gosoft.rmos.master.hello.ErrorResponse;

@RestControllerAdvice
public class UserControllerHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("SYM00002", userNotFoundException.getMessage()), HttpStatus.NO_CONTENT);
    }
}
