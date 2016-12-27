package no.sample.exchange.gateway.inbound.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by AB75448 on 21.12.2016.
 */
@Component("azureBlobResponseHandler")
public class AzureBlobResponseHandler {

    public void handle(Message message){
        System.out.println("Message flow is completed successfully for file::"+ (String) message.getHeaders().get("file_remoteFile"));
    }
}
