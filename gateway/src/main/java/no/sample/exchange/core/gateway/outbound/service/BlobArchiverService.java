package no.sample.exchange.core.gateway.outbound.service;

import no.sample.exchange.core.gateway.util.BlobInfo;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Ankit on 24-12-2016.
 */
@Component("blobArchiver")
public class BlobArchiverService {

    public void archive(Message message){
        Iterator<BlobInfo> blobInfoIterator = ((List<BlobInfo>)message.getPayload()).iterator();
        while(blobInfoIterator.hasNext()){
            BlobInfo blobInfo = blobInfoIterator.next();
            System.out.println("File is getting archived::"+ blobInfo.getBlobMetadata().getBlobName());
        }

    }

}
