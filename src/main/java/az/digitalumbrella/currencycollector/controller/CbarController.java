package az.digitalumbrella.currencycollector.controller;

import az.digitalumbrella.currencycollector.service.CbarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Currency;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cbar")
public class CbarController {

    private final CbarService cbarService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> syncCurrencyData(@RequestParam("date")
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        return cbarService.syncCurrencyData(date);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCurrencyData(@RequestParam("date")
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                LocalDate date) {

        return  cbarService.deleteByDate(date);
    }


}
