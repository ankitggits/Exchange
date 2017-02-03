package no.vipps.exchange.outbound.router;

import no.vipps.exchange.common.model.ResourceInfo;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.message.AdviceMessage;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Ankit on 24-12-2016.
 */

public class OutboundSourceTypeRouter {

    private Map<String,MessageChannel> sourceTypePrefixChannelMap;

    private String type;

    @Router
    public MessageChannel route(Message message) {
        MessageChannel messageChannel = null;
        String blobName = null;
        if(("list").equalsIgnoreCase(type)){
            blobName = ((List<ResourceInfo>) message.getPayload()).get(0).getResourceMetadata().getBlobName();
        }else{
            blobName = (String) message.getPayload();
        }
        Iterator<String> iterator = sourceTypePrefixChannelMap.keySet().iterator();
        while(iterator.hasNext()){
            String prefix = iterator.next();
            if(blobName.startsWith(prefix)){
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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
