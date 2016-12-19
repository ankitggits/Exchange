package no.sample.exchange.gateway.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ExchangeApplication {

	public static void main(String[] args) {
		 new SpringApplicationBuilder(ExchangeApplication.class)
         .web(false)
         .run(args);
	}
}
