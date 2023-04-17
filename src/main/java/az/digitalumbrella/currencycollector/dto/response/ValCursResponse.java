package az.digitalumbrella.currencycollector.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValCursResponse {

    private LocalDate date;

    private String type;

    private String code;

    private String nominal;

    private String name;

    private BigDecimal value;

}
