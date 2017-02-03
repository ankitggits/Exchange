package no.vipps.exchange.common.Helper;

import no.vipps.exchange.common.model.ResourceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Ankit on 23-12-2016.
 */
@Service
public class BlobStorageService {

    @Autowired
    ConfiguraitonService configuraitonService;

    @Autowired
    RestTemplate restTemplate;

    public ResourceInfo getBlob(String serviceEndpoint, String containerName, String blobName){
        ResourceInfo resourceInfo = new ResourceInfo();
        String url = serviceEndpoint.concat(containerName).concat("/").concat(blobName).concat("?").concat(configuraitonService.getSshString());
        try {
            ResponseEntity<byte[]> entity = restTemplate.exchange(new URI(url), HttpMethod.GET, null,byte[].class);
            resourceInfo.setBytes(entity.getBody());
            resourceInfo.setResourceMetadata(new ResourceInfo.ResourceMeta(blobName));
            return resourceInfo;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("file not found");
        }
    }
}
