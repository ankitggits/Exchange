package no.sample.exchange.gateway.Helper;

import no.sample.exchange.gateway.model.BlobInfo;
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

    public BlobInfo getBlob(String serviceEndpoint, String containerName, String blobName){
        BlobInfo blobInfo = new BlobInfo();
        String url = serviceEndpoint.concat(containerName).concat("/").concat(blobName).concat("?").concat(configuraitonService.getSshString());
        try {
            ResponseEntity<byte[]> entity = restTemplate.exchange(new URI(url), HttpMethod.GET, null,byte[].class);
            blobInfo.setBytes(entity.getBody());
            blobInfo.setBlobMetadata(new BlobInfo.BlobMeta(blobName));
            return blobInfo;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("file not found");
        }
    }
}
