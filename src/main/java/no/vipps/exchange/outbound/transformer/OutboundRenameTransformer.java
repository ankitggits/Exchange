package no.vipps.exchange.outbound.transformer;

import lombok.Getter;
import lombok.Setter;
import no.vipps.exchange.common.model.ResourceInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Ankit on 23-12-2016.
 */
@Getter
@Setter
public class OutboundRenameTransformer extends AbstractTransformer{

    private String suffix;
    private String prefix;

    @Override
    protected Message<?> doTransform(Message<?> message) throws Exception {
        List<ResourceInfo> resourceInfos = (List<ResourceInfo>) message.getPayload();
        Iterator<ResourceInfo> blobInfoIterator = resourceInfos.iterator();
        while(blobInfoIterator.hasNext()){
            ResourceInfo resourceInfo = blobInfoIterator.next();
            String blobName = resourceInfo.getResourceMetadata().getBlobName();
            String extension = FilenameUtils.getExtension(blobName);
            String blobNameWithOutExt = FilenameUtils.removeExtension(blobName);
            resourceInfo.getResourceMetadata().setExtension(extension);
            resourceInfo.getResourceMetadata().setFileName(prefix.concat(blobNameWithOutExt.concat(suffix).concat(".").concat(extension)));
        }
        return MessageBuilder.withPayload(resourceInfos).build();
    }

}
