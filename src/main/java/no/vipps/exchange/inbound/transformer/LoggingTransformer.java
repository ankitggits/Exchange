package no.vipps.exchange.inbound.transformer;

import no.vipps.exchange.common.model.ResourceInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component(value = "inboundLoggingService")
public class LoggingTransformer extends AbstractTransformer {

    @Override
    protected Message<ResourceInfo> doTransform(Message<?> message) throws Exception {
        ResourceInfo resourceInfo = new ResourceInfo();
        ResourceInfo.ResourceMeta resourceMeta = new ResourceInfo.ResourceMeta((String) message.getHeaders().get("file_remoteFile"));
        resourceInfo.setResourceMetadata(resourceMeta);
        InputStream targetStream = (InputStream) message.getPayload();
        byte[] bytes = IOUtils.toByteArray(targetStream);
        resourceInfo.setBytes(bytes);
        System.out.println("received a file with name:::"+ resourceMeta.getFileName());
        return MessageBuilder.withPayload(resourceInfo).build();
    }
}
