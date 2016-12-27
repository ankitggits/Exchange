package no.sample.exchange.gateway.inbound.Transformer;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URI;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component("strorageRequestTransformer")
public class StrorageRequestTransformer extends AbstractTransformer{

    @Override
    protected Message<byte[]> doTransform(Message<?> message) throws Exception{
        String fileName = (String) message.getHeaders().get("file_remoteFile");
        InputStream targetStream = (InputStream) message.getPayload();
        byte[] bytes = IOUtils.toByteArray(targetStream);
        return MessageBuilder.withPayload(bytes)
                .setHeader("Content-Type", "application/octet-stream")
                .setHeader("version","2015-02-21")
                .setHeader("date","Tue, 12 Dec 2016 15:28:13 GMT")
                .setHeader("blob-content-disposition","attachment; filename='"+fileName+"'")
                .setHeader("blob-type","BlockBlob")
                .setHeader("blobName",fileName)
                .setHeader("charset", "binary")
                .build();

    }
}
