package no.vipps.exchange.inbound.transformer;

import lombok.Getter;
import lombok.Setter;
import no.vipps.exchange.common.model.ResourceInfo;
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
    protected Message<ResourceInfo> doTransform(Message<?> message) throws Exception {
        ResourceInfo resourceInfo = (ResourceInfo) message.getPayload();
        String blobName = resourceInfo.getResourceMetadata().getBlobName();
        String extension = FilenameUtils.getExtension(blobName);
        String fileNameWithOutExt = FilenameUtils.removeExtension(blobName);
        resourceInfo.getResourceMetadata().setBlobName(prefix.concat(fileNameWithOutExt.concat(suffix).concat(".").concat(extension)));
        return MessageBuilder
                .withPayload(resourceInfo)
                .build();
    }

}