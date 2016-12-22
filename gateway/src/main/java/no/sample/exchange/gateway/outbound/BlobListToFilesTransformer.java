package no.sample.exchange.gateway.outbound;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Ankit on 22-12-2016.
 */
@Component("blobListToFilesTransformer")
public class BlobListToFilesTransformer {

    public void transform(Message message){
        System.out.println(message);
    }


}
