package dan.tp2021.cuentacorriente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ClientNotFoundException.class)
    public ResponseEntity<?> exception(ClientNotFoundException exception)
    {return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);}

    @ExceptionHandler(value = ConnectionFailException.class)
    public ResponseEntity<?> exceptionConnection(ConnectionFailException exception)
    {return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);}

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> exceptionGeneral(Exception exception)
    {return new ResponseEntity<>("Vuelva a intentarlo.", HttpStatus.NOT_FOUND);}
}
