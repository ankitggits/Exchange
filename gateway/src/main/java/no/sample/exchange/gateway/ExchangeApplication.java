package no.sample.exchange.gateway;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;

@SpringBootApplication
public class ExchangeApplication {

	public static void main(String[] args) {
		 new SpringApplicationBuilder(ExchangeApplication.class)
         .web(false)
         .run(args);
	}

	@Bean
	public SessionFactory<ChannelSftp.LsEntry> sftpSessionFactory() {
		DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
		factory.setHost("10.219.238.132");
		factory.setPort(22);
		factory.setUser("VIPPS001S");
		factory.setPassword("Norway123");
		factory.setAllowUnknownKeys(true);
		return new CachingSessionFactory<ChannelSftp.LsEntry>(factory);
	}
}
