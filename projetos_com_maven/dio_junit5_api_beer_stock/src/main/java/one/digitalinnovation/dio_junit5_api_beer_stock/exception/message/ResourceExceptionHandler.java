package one.digitalinnovation.dio_junit5_api_beer_stock.exception.message;

import one.digitalinnovation.dio_junit5_api_beer_stock.exception.message.ObjectNotFoundException;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.message.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request ){
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),
                "Message= " + e.fillInStackTrace(),
                System.currentTimeMillis()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

}
