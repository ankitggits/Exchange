package no.vipps.exchange.outbound.transformer;

import no.vipps.exchange.common.Helper.BlobStorageService;
import no.vipps.exchange.common.model.ResourceInfo;
import no.vipps.exchange.outbound.model.EnumerationResults;
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

    public Message<List<ResourceInfo>> doTransform(Message message){
        EnumerationResults results = (EnumerationResults) message.getPayload();
        Iterator<EnumerationResults.Blobs.Blob> blobsIterator = results.getBlobs().getBlob().iterator();
        List<ResourceInfo> resourceInfos = new ArrayList<ResourceInfo>();
        while(blobsIterator.hasNext()){
            EnumerationResults.Blobs.Blob blob = blobsIterator.next();
            ResourceInfo resourceInfo = storageService.getBlob(results.getServiceEndpoint(), results.getContainerName(), blob.getName());
            resourceInfo.getBlobMetadata().setUploadedDate(blob.getProperties().getLastModified());
            resourceInfos.add(resourceInfo);
        }
        return MessageBuilder.withPayload(resourceInfos).build();
    }

}
