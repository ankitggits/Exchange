package no.sample.exchange.gateway;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;

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
}
