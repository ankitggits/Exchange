package no.sample.exchange.gateway.common.Helper;

import org.springframework.stereotype.Component;

/**
 * Created by AB75448 on 21.12.2016.
 */
@Component("configurationService")
public class ConfiguraitonService {


    public String getSshString(){
        return "sv=2015-12-11&ss=b&srt=sco&sp=rwdlac&se=2017-08-31T00:33:00Z&st=2017-01-02T13:33:00Z&spr=https&sig=Olbe3hpDZWRmorvOtybne2WuQdwXfgd7UwslF%2Bm%2BX8A%3D";
    }

    public String getSshStringForList(){
        return "restype=container&comp=list&".concat(getSshString());
    }

}
