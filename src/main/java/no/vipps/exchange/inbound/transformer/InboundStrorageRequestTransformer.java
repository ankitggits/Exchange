package no.vipps.exchange.inbound.transformer;

import no.vipps.exchange.common.model.ResourceInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.*;

import static no.vipps.exchange.common.util.ExchangeUtil.getCurrentDateAsString;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component("inboundStrorageRequestTransformer")
public class InboundStrorageRequestTransformer extends AbstractTransformer{

    @Override
    protected Message<byte[]> doTransform(Message<?> message) throws Exception{
        ResourceInfo resourceInfo = (ResourceInfo) message.getPayload();
        return MessageBuilder.withPayload(resourceInfo.getBytes())
                .setHeader("Content-Type", "application/octet-stream")
                .setHeader("version","2015-02-21")
                .setHeader("date",getCurrentDateAsString())
                .setHeader("blob-content-disposition","attachment; filename='"+resourceInfo.getResourceMetadata().getBlobName()+"'")
                .setHeader("blob-type","BlockBlob")
                .setHeader("blobName",resourceInfo.getResourceMetadata().getBlobName())
                .setHeader("charset", "binary")
                .setHeader("sourceFilename", resourceInfo.getResourceMetadata().getFileName())
                .build();

    }
}
