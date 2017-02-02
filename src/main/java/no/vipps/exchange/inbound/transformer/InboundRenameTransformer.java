package no.vipps.exchange.inbound.transformer;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FilenameUtils;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * Created by AB75448 on 02.02.2017.
 */
@Getter
@Setter
public class InboundRenameTransformer extends AbstractTransformer {

    private String suffix;
    private String prefix;

    @Override
    protected Message<?> doTransform(Message<?> message) throws Exception {
        MessageHeaders messageHeaders = message.getHeaders();
        String fileName = (String) messageHeaders.get("file_remoteFile");
        String extension = FilenameUtils.getExtension(fileName);
        String fileNameWithOutExt = FilenameUtils.removeExtension(fileName);
        return MessageBuilder
                .withPayload(message.getPayload())
                .setHeader("file_remoteFile", fileName)
                .setHeader("blobname", prefix.concat(fileNameWithOutExt.concat(suffix).concat(".").concat(extension)))
                .build();
    }

}