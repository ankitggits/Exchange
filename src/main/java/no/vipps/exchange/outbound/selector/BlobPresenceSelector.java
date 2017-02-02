package no.vipps.exchange.outbound.selector;

import no.vipps.exchange.outbound.model.EnumerationResults;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by Ankit on 23-12-2016.
 */
@Component("blobPresenceSelector")
public class BlobPresenceSelector implements MessageSelector{

    @Override
    public boolean accept(Message<?> message) {
        EnumerationResults results = (EnumerationResults)message.getPayload();
        EnumerationResults.Blobs blobs = results.getBlobs();
        return (blobs.getBlob()!=null && !blobs.getBlob().isEmpty() && blobs.getBlob().size()>0);
    }

}
