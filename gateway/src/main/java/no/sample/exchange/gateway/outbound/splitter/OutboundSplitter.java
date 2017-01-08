package no.sample.exchange.gateway.outbound.splitter;

import no.sample.exchange.gateway.model.BlobInfo;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ankit on 28-12-2016.
 */
@Component
public class OutboundSplitter extends AbstractMessageSplitter{

    @Override
    protected List<Message<byte[]>> splitMessage(Message<?> message) {
        List<Message<byte[]>> messages = new ArrayList();
        List<BlobInfo> blobInfos = (List<BlobInfo>) message.getPayload();
        Iterator<BlobInfo> blobInfoIterator = blobInfos.iterator();
        while(blobInfoIterator.hasNext()) {
            BlobInfo blobInfo = blobInfoIterator.next();
            messages.add(MessageBuilder.withPayload(blobInfo.getBytes()).setHeader(FileHeaders.FILENAME, blobInfo.getBlobMetadata().getBlobName()).build());
        }
        return messages;
    }
}
