package th.co.gosoft.rmos.master.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HelloControllerHandler {
   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("SYM00002", methodArgumentNotValidException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(MissingServletRequestParameterException missingServletRequestParameterException) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("SYM00003", missingServletRequestParameterException.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
