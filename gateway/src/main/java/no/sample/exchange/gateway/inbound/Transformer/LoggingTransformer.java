package no.sample.exchange.gateway.inbound.Transformer;

import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by AB75448 on 20.12.2016.
 */
@Component(value = "inboundLoggingService")
public class LoggingTransformer {

    public File log(File file){
        System.out.println("received a file with name:::"+ file.getName());
        return file;
    }
}
