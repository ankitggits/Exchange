package no.sample.exchange.gateway.outbound;

import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component(value = "outboundLoggingService")
public class OutboundLoggingService {

    public void log(File file){
        System.out.println("received a file with name:::"+ file.getName());
        //return file;
    }
}
