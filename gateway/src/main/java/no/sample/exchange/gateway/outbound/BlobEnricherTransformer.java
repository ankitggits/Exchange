package no.sample.exchange.gateway.outbound;

import no.sample.exchange.gateway.outbound.model.EnumerationResults;
import no.sample.exchange.gateway.util.BlobStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ankit on 22-12-2016.
 */
@Component("blobEnricherTransformer")
public class BlobEnricherTransformer extends AbstractTransformer{

    @Autowired
    BlobStorageService storageService;

    public Message<?> doTransform(Message message){
        EnumerationResults results = (EnumerationResults) message.getPayload();
        Iterator<EnumerationResults.Blobs.Blob> blobsIterator = results.getBlobs().getBlob().iterator();
        while(blobsIterator.hasNext()){
            EnumerationResults.Blobs.Blob blob = blobsIterator.next();
            String url = results.getServiceEndpoint().concat(results.getContainerName()).concat("/").concat(blob.getName());
            storageService.getBlob(url);
        }
        return message;
    }

}
