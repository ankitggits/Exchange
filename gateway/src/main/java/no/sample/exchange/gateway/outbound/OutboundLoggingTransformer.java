package no.sample.exchange.gateway.outbound;

import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component(value = "outboundLoggingService")
public class OutboundLoggingTransformer extends AbstractTransformer{

    public Message<?> doTransform(Message message){
        System.out.println("received a file with name:::"+ message.getPayload());
        return message;
    }
}
