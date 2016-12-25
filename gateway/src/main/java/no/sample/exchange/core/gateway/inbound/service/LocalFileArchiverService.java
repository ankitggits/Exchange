package no.sample.exchange.core.gateway.inbound.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by AB75448 on 21.12.2016.
 */
@Component("localFileArchiver")
public class LocalFileArchiverService {

    public void archive(Message message){
        File file = new File("local-dir/inbound-integration-config.xml");
        if(file.exists()){
            file.delete();
        }
        System.out.println("Message is archived");
    }
}
