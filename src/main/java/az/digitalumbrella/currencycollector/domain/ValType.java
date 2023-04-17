package az.digitalumbrella.currencycollector.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ValType.TABLE_NAME)
public class ValType  {

    public static final String TABLE_NAME = "val_types";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "val_curs_id")
    private ValCurs valCurs;

    private String type;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "valType")
    private List<Valute> valutes;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
