package az.digitalumbrella.currencycollector.dto.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString(exclude = "password")
public class LoginRequest {

    @NotBlank(message = "Username must be defined")
    @Size(min = 1, max = 20)
    private String username;

    @NotBlank(message = "Password must be defined")
    @Size(min = 1, max =20)
    private String password;

}