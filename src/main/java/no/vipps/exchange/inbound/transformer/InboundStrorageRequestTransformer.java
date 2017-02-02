package no.vipps.exchange.inbound.transformer;

import org.apache.commons.io.IOUtils;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component("inboundStrorageRequestTransformer")
public class InboundStrorageRequestTransformer extends AbstractTransformer{

    @Override
    protected Message<byte[]> doTransform(Message<?> message) throws Exception{
        String fileName = (String) message.getHeaders().get("file_remoteFile");
        String blobName = (String) message.getHeaders().get("blobname");
        InputStream targetStream = (InputStream) message.getPayload();
        byte[] bytes = IOUtils.toByteArray(targetStream);
        return MessageBuilder.withPayload(bytes)
                .setHeader("Content-Type", "application/octet-stream")
                .setHeader("version","2015-02-21")
                .setHeader("date","Tue, 12 Dec 2016 15:28:13 GMT")
                .setHeader("blob-content-disposition","attachment; filename='"+blobName+"'")
                .setHeader("blob-type","BlockBlob")
                .setHeader("blobName",blobName)
                .setHeader("charset", "binary")
                .setHeader("sourceFilename", fileName)
                .build();

    }
}
