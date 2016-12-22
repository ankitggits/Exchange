package no.sample.exchange.gateway.outbound;

import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Ankit on 22-12-2016.
 */
@Component("blobEnricherTransformer")
public class BlobEnricherTransformer extends AbstractTransformer{

    public Message<?> doTransform(Message message){
        System.out.println(message.getPayload());
        return message;
    }

}
