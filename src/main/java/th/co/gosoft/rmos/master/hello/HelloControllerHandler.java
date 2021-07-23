package th.co.gosoft.rmos.master.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HelloControllerHandler {
    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(InvalidNameException invalidNameException) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("SYM00001", "Error Jaaaaaaaa."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(InvalidAgeException invalidAgeException) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("SYM00002", "Error Age Jaaaaaaaa."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(MissingServletRequestParameterException missingServletRequestParameterException) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("SYM00003", missingServletRequestParameterException.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
