package az.digitalumbrella.currencycollector.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ExceptionResponse handle(AlreadyExistException ex) {
        log.error("Resource already exist {}", ex.getMessage());
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ExceptionResponse handle(NotFoundException ex) {
        log.error("Resource not found  {}", ex.getMessage());
        return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ExceptionResponse handle(MethodArgumentNotValidException ex) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }



}

