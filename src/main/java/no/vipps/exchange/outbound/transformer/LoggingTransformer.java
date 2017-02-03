package no.vipps.exchange.outbound.transformer;

import no.vipps.exchange.common.model.ResourceInfo;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component(value = "outboundLoggingService")
public class LoggingTransformer extends AbstractTransformer{

    public Message<?> doTransform(Message message){
        List<ResourceInfo> resourceInfos = (List<ResourceInfo>) message.getPayload();
        Iterator<ResourceInfo> resourceInfoIterator = resourceInfos.iterator();
        while(resourceInfoIterator.hasNext()){
            ResourceInfo resourceInfo = resourceInfoIterator.next();
            System.out.println("received a file with name:::"+ resourceInfo.getResourceMetadata().getBlobName());
        }
        return message;
    }
}
