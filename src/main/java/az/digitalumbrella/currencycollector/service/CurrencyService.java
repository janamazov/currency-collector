package az.digitalumbrella.currencycollector.service;

import az.digitalumbrella.currencycollector.dto.enumeration.Currency;
import az.digitalumbrella.currencycollector.dto.response.ValCursResponse;
import az.digitalumbrella.currencycollector.exception.NotFoundException;
import az.digitalumbrella.currencycollector.repository.ValCursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final ValCursRepository valCursRepository;
    private final static String VAL_TYPE = "Xarici valyutalar";


    public ValCursResponse getByDateAndCurrency(LocalDate date, Currency currency) {
        return valCursRepository.getByDateAndCurrencyCode(date, VAL_TYPE, currency.name())
                .orElseThrow(NotFoundException::new);
    }

    public List<ValCursResponse> getAllByDate(LocalDate date) {
        List<ValCursResponse> allUsingDate = valCursRepository.getAllUsingDate(date, VAL_TYPE);
        if (allUsingDate.isEmpty()) throw new NotFoundException();
        return allUsingDate;
    }

    public List<ValCursResponse> getAllByCurrency(Currency currency) {
        List<ValCursResponse> allUsingCurrency = valCursRepository.getAllByCurrencyCode(VAL_TYPE, currency.name());
        if (allUsingCurrency.isEmpty()) throw new NotFoundException();
        return allUsingCurrency;
    }

}
