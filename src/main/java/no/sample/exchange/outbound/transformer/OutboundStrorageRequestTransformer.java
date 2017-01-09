package no.sample.exchange.outbound.transformer;

import org.apache.commons.io.IOUtils;
import org.springframework.integration.message.AdviceMessage;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component("outboundStrorageRequestTransformer")
public class OutboundStrorageRequestTransformer extends AbstractTransformer{

    @Override
    protected Message doTransform(Message<?> message) throws Exception{
        String blobName = (String) ((AdviceMessage)message).getInputMessage().getHeaders().get("file_name");
        return MessageBuilder.withPayload(blobName)
                .setHeader("version","2015-02-21")
                .setHeader("date","Tue, 12 Dec 2016 15:28:13 GMT")
                .build();

    }
}
