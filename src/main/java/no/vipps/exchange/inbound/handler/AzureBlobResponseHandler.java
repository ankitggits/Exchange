package no.vipps.exchange.inbound.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by AB75448 on 21.12.2016.
 */
@Component("azureBlobResponseHandler")
public class AzureBlobResponseHandler extends AbstractMessageHandler{

    @Override
    protected void handleMessageInternal(Message<?> message) throws Exception {
        String fileName =  (String) message.getHeaders().get("blobName");
        ResponseEntity responseEntity = (ResponseEntity) message.getPayload();
        if(responseEntity.getStatusCode()==HttpStatus.CREATED){
            handleSuccess(fileName);
        }else{
            handleFailure(fileName);
        }
    }

    private void handleSuccess(String fileName){
        System.out.println("Message flow is completed successfully for file::"+ fileName);
    }

    private void handleFailure(String fileName){
        System.out.println("Message flow is failed at azure upload for file::"+ fileName);
    }
}
