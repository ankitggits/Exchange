package no.sample.exchange.gateway.config;

import com.jcraft.jsch.ChannelSftp.LsEntry;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.metadata.SimpleMetadataStore;
import org.springframework.integration.sftp.filters.SftpPersistentAcceptOnceFileListFilter;
import org.springframework.integration.sftp.inbound.SftpStreamingMessageSource;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpRemoteFileTemplate;
import org.springframework.integration.transformer.StreamTransformer;

import java.io.InputStream;

/**
 * Created by AB75448 on 14.12.2016.
 */
public class StreamingInBoundConfiguration {

    public static void main(String[] args) {
        new SpringApplicationBuilder(StreamingInBoundConfiguration.class)
                .web(false)
                .run(args);
    }

    @Bean
    @InboundChannelAdapter(channel = "stream")
    public MessageSource<InputStream> ftpMessageSource() {
        SftpStreamingMessageSource messageSource = new SftpStreamingMessageSource(template(), null);
        messageSource.setRemoteDirectory("/Consumer/");
        messageSource.setFilter(new SftpPersistentAcceptOnceFileListFilter(new SimpleMetadataStore(), "streaming"));
        return messageSource;
    }
    
    @Bean
    public SessionFactory<LsEntry> sftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        factory.setHost("10.219.238.132");
        factory.setPort(22);
        factory.setUser("VIPPS001S");
        factory.setPassword("Norway123");
        factory.setAllowUnknownKeys(true);
        return new CachingSessionFactory<LsEntry>(factory);
    }

    @Bean
    @Transformer(inputChannel = "stream", outputChannel = "data")
    public org.springframework.integration.transformer.Transformer transformer() {
        return new StreamTransformer();
    }

    @Bean
    public SftpRemoteFileTemplate template() {
        return new SftpRemoteFileTemplate(sftpSessionFactory());
    }

}
