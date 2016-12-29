package no.sample.exchange.gateway.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ankit on 27-12-2016.
 */
@Component("mailRequestHandler")
public class MailRequestHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ServiceActivator
    public MailMessage handle(MessagingException exc) {
        logger.error("Request failed. Sending mail");
        MailMessage mailMsg = new SimpleMailMessage();
        return mailMsg;
    }
}