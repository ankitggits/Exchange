package no.sample.exchange.inbound.router;

import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Ankit on 24-12-2016.
 */

public class InboundSourceTypeRouter {

    private Map<String,MessageChannel> sourceTypePrefixChannelMap;

    @Router
    public MessageChannel route(Message message) {
        MessageChannel messageChannel = null;
        String fileName = (String) message.getHeaders().get("file_remoteFile");
        Iterator<String> iterator = sourceTypePrefixChannelMap.keySet().iterator();
        while(iterator.hasNext()){
            String prefix = iterator.next();
            if(fileName.startsWith(prefix)){
                messageChannel = sourceTypePrefixChannelMap.get(prefix);
                break;
            }
        }
        Assert.notNull(messageChannel, "Message-channel must not be null, please check prefix");
        return messageChannel;
    }

    public Map<String, MessageChannel> getSourceTypePrefixChannelMap() {
        return sourceTypePrefixChannelMap;
    }

    public void setSourceTypePrefixChannelMap(Map<String, MessageChannel> sourceTypePrefixChannelMap) {
        this.sourceTypePrefixChannelMap = sourceTypePrefixChannelMap;
    }
}
