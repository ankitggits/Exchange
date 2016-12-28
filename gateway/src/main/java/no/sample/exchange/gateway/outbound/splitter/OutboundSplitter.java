package no.sample.exchange.gateway.outbound.splitter;

import no.sample.exchange.gateway.util.BlobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
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
    protected List<Message<BlobInfo>> splitMessage(Message<?> message) {
        List<Message<BlobInfo>> messages = new ArrayList();
        List<BlobInfo> blobInfos = (List<BlobInfo>) message.getPayload();
        Iterator<BlobInfo> blobInfoIterator = blobInfos.iterator();
        while(blobInfoIterator.hasNext()) {
            messages.add(MessageBuilder.withPayload(blobInfoIterator.next()).build());
        }
        return messages;
    }
}
