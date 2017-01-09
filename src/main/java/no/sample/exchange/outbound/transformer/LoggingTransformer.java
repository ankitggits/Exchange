package no.sample.exchange.outbound.transformer;

import no.sample.exchange.common.model.BlobInfo;
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
        List<BlobInfo> blobInfos = (List<BlobInfo>) message.getPayload();
        Iterator<BlobInfo> blobInfoIterator = blobInfos.iterator();
        while(blobInfoIterator.hasNext()){
            BlobInfo blobInfo = blobInfoIterator.next();
            System.out.println("received a file with name:::"+ blobInfo.getBlobMetadata().getBlobName());
        }
        return message;
    }
}
