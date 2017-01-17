package no.sample.exchange;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@ImportResource("classpath:integration-config/integration-config.xml")
public class ExchangeApplication {

	public static void main(String[] args) {
		System.setProperty("proxyHost", "proxy");
		System.setProperty("proxyPort", "88");
		new SpringApplicationBuilder(ExchangeApplication.class)
         .web(false)
         .run(args);
	}

	@Bean
	public RestTemplate restTemplate(List<HttpMessageConverter<?>> messageConverters) {
		return new RestTemplate(messageConverters);
	}

	@Bean
	public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
		return new ByteArrayHttpMessageConverter();
	}
}
