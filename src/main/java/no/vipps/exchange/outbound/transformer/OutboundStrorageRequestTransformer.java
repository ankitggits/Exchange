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
                .setHeader("date" , getCurrentDateAsString())
                .build();

    }

    private static String getCurrentDateAsString() throws ParseException {
        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormatGmt.format(new Date());
    }

}
