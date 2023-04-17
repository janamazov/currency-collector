package az.digitalumbrella.currencycollector.service;

import az.digitalumbrella.currencycollector.client.CbarClient;
import az.digitalumbrella.currencycollector.client.model.ValCursDTO;
import az.digitalumbrella.currencycollector.domain.ValCurs;
import az.digitalumbrella.currencycollector.exception.AlreadyExistException;
import az.digitalumbrella.currencycollector.exception.NotFoundException;
import az.digitalumbrella.currencycollector.repository.ValCursRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Slf4j
@Service
@RequiredArgsConstructor
public class CbarService {

    private final ValCursRepository valCursRepository;
    private final ModelMapper mapper;
    private final CbarClient client;

    @Value("${cbar.url}")
    private String currencyURI;


    public ResponseEntity<?> syncCurrencyData(LocalDate date) {
        if (valCursRepository.existsByDate(date)) throw new AlreadyExistException();

        ValCurs valCurs = mapper.map(getCurrencyData(date), ValCurs.class);

        valCurs.getValTypes().forEach(valType -> {
            valType.setValCurs(valCurs);
            valType.getValutes().forEach(v -> v.setValType(valType));
        });
        valCursRepository.save(valCurs);
        return ResponseEntity.ok().body("Succesfully synced");
    }

    private ValCursDTO getCurrencyData(LocalDate date) {
        URI determinedBasePathUri = URI.create(getURI(date));
        ValCursDTO body = client.getCurrencyData(determinedBasePathUri).getBody();
        if (body != null) body.setDate(date);
        return body;
    }

    public ResponseEntity<String> deleteByDate(LocalDate date) {
        if (!valCursRepository.existsByDate(date)) throw new NotFoundException();
        valCursRepository.deleteByDate(date);
        return ResponseEntity.ok().body("Succesfully deleted");
    }
    private String getURI(LocalDate date) {
        return String.format("%s/%s.%s", currencyURI, date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), "xml");
    }


}
