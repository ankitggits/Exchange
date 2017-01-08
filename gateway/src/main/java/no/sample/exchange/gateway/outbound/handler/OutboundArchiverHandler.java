package no.sample.exchange.gateway.outbound.handler;

import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by Ankit on 24-12-2016.
 */
@Component("outboundArchiver")
public class OutboundArchiverHandler extends AbstractMessageHandler{

    @Override
    public void handleMessageInternal(Message<?> message) throws Exception {
        String fileName = (String) message.getHeaders().get(FileHeaders.FILENAME);
        System.out.println("File is getting archived::"+ fileName);
    }

}
