package no.sample.api.apim;

import org.springframework.core.env.Environment;

/**
 * Created by AB75448 on 05.01.2017.
 */
public enum APIMOutboundStream {
    NETAXEPT,
    TSP,
    CALLBACK,
    BINLIST,
    PSP,
    TEST;

    public String getURI(Environment environment){
        return environment.getProperty("apim.".concat(this.name().toLowerCase()));
    }
}
