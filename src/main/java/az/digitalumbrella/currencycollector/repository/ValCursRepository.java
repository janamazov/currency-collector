package az.digitalumbrella.currencycollector.repository;

import az.digitalumbrella.currencycollector.domain.ValCurs;
import az.digitalumbrella.currencycollector.dto.response.ValCursResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ValCursRepository extends JpaRepository<ValCurs, Long> {

     boolean existsByDate(LocalDate date);

    @Query("select new az.digitalumbrella.currencycollector.dto.response.ValCursResponse( vc.date, vt.type,  v.code, v.nominal, v.name, v.value)" +
            " from ValCurs vc join ValType vt on vt.valCurs.id=vc.id join Valute v on v.valType.id=vt.id" +
            " where vc.date=:date and vt.type=:type and v.code=:code")
    Optional<ValCursResponse> getByDateAndCurrencyCode(@Param("date") LocalDate date,
                                                       @Param("type") String type,
                                                       @Param("code") String code);

    @Query("select new az.digitalumbrella.currencycollector.dto.response.ValCursResponse( vc.date, vt.type,  v.code, v.nominal, v.name, v.value) " +
            "from ValCurs vc join ValType vt on vt.valCurs.id=vc.id join Valute v on v.valType.id=vt.id " +
            "where vc.date=:date and vt.type=:type")
    List<ValCursResponse> getAllUsingDate(@Param("date") LocalDate date,
                                          @Param("type") String type);

    @Query("select new az.digitalumbrella.currencycollector.dto.response.ValCursResponse( vc.date, vt.type,  v.code, v.nominal, v.name, v.value) " +
            "from ValCurs vc join ValType vt on vt.valCurs.id=vc.id join Valute v on v.valType.id=vt.id " +
            "where v.code=:code and vt.type=:type")
    List<ValCursResponse> getAllByCurrencyCode(@Param("type") String type,
                                               @Param("code") String code);


    @Transactional
    void deleteByDate(LocalDate date);
}
