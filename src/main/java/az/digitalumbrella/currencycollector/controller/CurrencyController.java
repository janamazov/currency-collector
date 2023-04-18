package az.digitalumbrella.currencycollector.controller;


import az.digitalumbrella.currencycollector.dto.response.ValCursResponse;
import az.digitalumbrella.currencycollector.dto.enumeration.Currency;
import az.digitalumbrella.currencycollector.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/currencies")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/get-date-and-currency")
    public ValCursResponse getByDateAndCurrencyAgainstAzn(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
             @RequestParam("code") Currency  currencyCode) {
        return currencyService.getByDateAndCurrency(date, currencyCode);
    }

    @GetMapping("/get-by-date")
    public List<ValCursResponse> getAllByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return currencyService.getAllByDate(date);
    }

    @GetMapping("/get-by-code")
    public List<ValCursResponse> getAllByCurrency(@RequestParam("code") Currency currencyCode) {
        return currencyService.getAllByCurrency(currencyCode);
    }



}
