package no.sample.exchange.gateway.inbound;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by AB75448 on 21.12.2016.
 */
@Component("inboundArchiver")
public class InboundArchiver {

    public void archive(Message message){
        System.out.println("Message is archived");
    }
}
