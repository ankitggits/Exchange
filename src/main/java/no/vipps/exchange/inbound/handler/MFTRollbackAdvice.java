package no.vipps.exchange.inbound.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Created by AB75448 on 02.02.2017.
 */
@Component("rollbackAdvice")
public class MFTRollbackAdvice extends AbstractRequestHandlerAdvice {

    @Autowired
    @Qualifier("inbound-sftp-rollback-channel")
    MessageChannel messageChannel;

    @Override
    protected Object doInvoke(ExecutionCallback callback, Object target, Message<?> message) throws Exception {
        try {
            return callback.execute();
        }catch (Exception e) {
            messageChannel.send(MessageBuilder.withPayload(message.getPayload()).setHeader(FileHeaders.FILENAME, message.getHeaders().get("sourceFilename")).build());
            throw e;
        }
    }

}
