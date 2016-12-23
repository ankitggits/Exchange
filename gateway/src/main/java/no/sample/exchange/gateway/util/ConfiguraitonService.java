package no.sample.exchange.gateway.util;

import no.sample.exchange.gateway.outbound.model.EnumerationResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by AB75448 on 21.12.2016.
 */
@Component("configurationService")
public class ConfiguraitonService {


    public String getSshString(){
        return "sv=2015-12-11&ss=b&srt=sco&sp=rwdlac&se=2016-12-31T23:10:07Z&st=2016-12-20T12:10:07Z&spr=https&sig=blgvXWJxmew8T8Usrzv1DLZIhDTTTSsiQzUBBurVjNA%3D";
    }

    public String getSshStringForList(){
        return "restype=container&comp=list&sv=2015-12-11&ss=b&srt=sco&sp=rwdlac&se=2016-12-31T23:10:07Z&st=2016-12-20T12:10:07Z&spr=https&sig=blgvXWJxmew8T8Usrzv1DLZIhDTTTSsiQzUBBurVjNA%3D";
    }

    public boolean isPayloadAccepted(EnumerationResults results){
        return (results.getBlobs().getBlob()!=null && !results.getBlobs().getBlob().isEmpty() && results.getBlobs().getBlob().size()>0);
    }
}
