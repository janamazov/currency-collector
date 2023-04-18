package az.digitalumbrella.currencycollector.controller;

import az.digitalumbrella.currencycollector.service.CbarService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cbar")
public class CbarController {

    private final CbarService cbarService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String syncCurrencyData(@RequestParam("date")
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        return cbarService.syncCurrencyData(date);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCurrencyData(@RequestParam("date")
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   LocalDate date) {
        cbarService.deleteByDate(date);
    }


}
