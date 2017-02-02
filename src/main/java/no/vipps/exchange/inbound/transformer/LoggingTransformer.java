package no.vipps.exchange.inbound.transformer;

import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component(value = "inboundLoggingService")
public class LoggingTransformer extends AbstractTransformer {

    @Override
    protected Object doTransform(Message<?> message) throws Exception {
        System.out.println("received a file with name:::"+ message.getHeaders().get("file_remoteFile"));
        return message;
    }
}
