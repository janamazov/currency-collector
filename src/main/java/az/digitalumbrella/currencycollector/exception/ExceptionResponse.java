package az.digitalumbrella.currencycollector.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ExceptionResponse {

    private Integer code;
    private String message;
}
