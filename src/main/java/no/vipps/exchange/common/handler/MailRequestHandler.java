package no.vipps.exchange.common.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

/**
 * Created by Ankit on 27-12-2016.
 */
@Component("mailRequestHandler")
public class MailRequestHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public MailMessage handle(MessagingException exc) {
        logger.error("Request failed. Sending mail", exc);

        MailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setFrom("ankit.java8@gmail.com");
        mailMsg.setTo("ankit.singh@dnb.no");
        mailMsg.setSubject("ERROR OCCURED ON MFT-STORAGE EXCHANGE");

        StringBuilder textMessage = new StringBuilder(exc.getMessage());
        mailMsg.setText(textMessage.toString());

        return mailMsg;
    }

}