package no.vipps.exchange.outbound.splitter;

import no.vipps.exchange.common.model.ResourceInfo;
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
        List<ResourceInfo> resourceInfos = (List<ResourceInfo>) message.getPayload();
        Iterator<ResourceInfo> blobInfoIterator = resourceInfos.iterator();
        while(blobInfoIterator.hasNext()) {
            ResourceInfo resourceInfo = blobInfoIterator.next();
            messages.add(MessageBuilder.withPayload(resourceInfo.getBytes()).setHeader(FileHeaders.FILENAME, resourceInfo.getBlobMetadata().getBlobName()).build());
        }
        return messages;
    }
}
