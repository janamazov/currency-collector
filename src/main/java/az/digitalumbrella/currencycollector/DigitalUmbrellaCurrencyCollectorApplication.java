package az.digitalumbrella.currencycollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DigitalUmbrellaCurrencyCollectorApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DigitalUmbrellaCurrencyCollectorApplication.class, args);


	}


}
