package no.vipps.exchange.outbound.transformer;

import org.apache.commons.io.IOUtils;
import org.springframework.integration.message.AdviceMessage;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static no.vipps.exchange.common.util.ExchangeUtil.getCurrentDateAsString;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component("outboundStrorageRequestTransformer")
public class OutboundStrorageRequestTransformer extends AbstractTransformer{

    @Override
    protected Message doTransform(Message<?> message) throws Exception{
        Message originalMessage = ((AdviceMessage)message).getInputMessage();
        String blobName = (String) originalMessage.getHeaders().get("sourceFilename");
        return MessageBuilder.withPayload(originalMessage.getPayload())
                .setHeader("Content-Type", "application/octet-stream")
                .setHeader("version","2015-02-21")
                .setHeader("date",getCurrentDateAsString())
                .setHeader("blob-content-disposition","attachment; filename='"+blobName)
                .setHeader("blob-type","BlockBlob")
                .setHeader("blobName",blobName)
                .setHeader("charset", "binary")
                .build();


    }



}
