package az.digitalumbrella.currencycollector.client;

import az.digitalumbrella.currencycollector.client.model.ValCursDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(value = "CbarClient", url = "${cbar.url}")
public interface CbarClient {

    @GetMapping()
    ResponseEntity<ValCursDTO> getCurrencyData(URI baseUrl);
}
