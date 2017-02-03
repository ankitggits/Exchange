package no.vipps.exchange.common.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by AB75448 on 21.12.2016.
 */
@Component("configurationService")
public class ConfiguraitonService {

    @Value("${storage.ssh-string}")
    private String sshString;


    public String getSshString(){
        return sshString;
    }

    public String getSshStringForList(){
        return "restype=container&comp=list&".concat(getSshString());
    }

}
