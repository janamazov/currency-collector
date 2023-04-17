package az.digitalumbrella.currencycollector.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Valute.TABLE_NAME)
public class Valute  {

    public static final String TABLE_NAME = "valutes";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "val_type_id")
    @ToString.Exclude
    private ValType valType;

    private String code;
    private String name;
    private String nominal;
    private BigDecimal value;

}
