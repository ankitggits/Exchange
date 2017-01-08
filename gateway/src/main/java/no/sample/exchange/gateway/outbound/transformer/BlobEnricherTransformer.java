package no.sample.exchange.gateway.outbound.transformer;

import no.sample.exchange.gateway.outbound.model.EnumerationResults;
import no.sample.exchange.gateway.model.BlobInfo;
import no.sample.exchange.gateway.Helper.BlobStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ankit on 22-12-2016.
 */
@Component("blobEnricherTransformer")
public class BlobEnricherTransformer extends AbstractTransformer{

    @Autowired
    BlobStorageService storageService;

    public Message<List<BlobInfo>> doTransform(Message message){
        EnumerationResults results = (EnumerationResults) message.getPayload();
        Iterator<EnumerationResults.Blobs.Blob> blobsIterator = results.getBlobs().getBlob().iterator();
        List<BlobInfo> blobInfos = new ArrayList<BlobInfo>();
        while(blobsIterator.hasNext()){
            EnumerationResults.Blobs.Blob blob = blobsIterator.next();
            BlobInfo blobInfo = storageService.getBlob(results.getServiceEndpoint(), results.getContainerName(), blob.getName());
            blobInfo.getBlobMetadata().setUploadedDate(blob.getProperties().getLastModified());
            blobInfos.add(blobInfo);
        }
        return MessageBuilder.withPayload(blobInfos).build();
    }

}
