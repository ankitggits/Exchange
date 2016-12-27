package no.sample.exchange.gateway.outbound.transformer;

import no.sample.exchange.gateway.util.BlobInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Ankit on 23-12-2016.
 */
public class FileNameTransformer extends AbstractTransformer{

    private String suffix;

    @Override
    protected Message<?> doTransform(Message<?> message) throws Exception {
        List<BlobInfo> blobInfos = (List<BlobInfo>) message.getPayload();
        Iterator<BlobInfo> blobInfoIterator = blobInfos.iterator();
        while(blobInfoIterator.hasNext()){
            BlobInfo blobInfo = blobInfoIterator.next();
            String blobName = blobInfo.getBlobMetadata().getBlobName();
            String extension = FilenameUtils.getExtension(blobName);
            String blobNameWithOutExt = FilenameUtils.removeExtension(blobName);
            blobInfo.getBlobMetadata().setExtension(extension);
            blobInfo.getBlobMetadata().setFileName(blobNameWithOutExt.concat(suffix).concat(".").concat(extension));
            System.out.println("file name transformed to ::"+ blobInfo.getBlobMetadata().getFileName());
        }
        return MessageBuilder.withPayload(blobInfos).build();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
