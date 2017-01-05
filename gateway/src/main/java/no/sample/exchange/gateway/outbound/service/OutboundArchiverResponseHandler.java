package no.sample.exchange.gateway.outbound.service;

import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by AB75448 on 02.01.2017.
 */
@Component("outboundArchiveResponseHandler")
public class OutboundArchiverResponseHandler extends AbstractMessageHandler {

    @Override
    public void handleMessageInternal(Message<?> message) throws Exception {
        System.out.println("File is archived successfully");
    }

}

