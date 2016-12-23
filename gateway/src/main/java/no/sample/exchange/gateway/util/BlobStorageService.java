package no.sample.exchange.gateway.util;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.ListBlobItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Ankit on 23-12-2016.
 */
@Service
public class BlobStorageService {

    @Autowired
    ConfiguraitonService configuraitonService;

    public InputStream getBlob(String url){
        RestTemplate restTemplate = new RestTemplate();
        try {
            url+="?"+configuraitonService.getSshString();
            ResponseEntity<String> entity = restTemplate.exchange(new URI(url), HttpMethod.GET, null,String.class);
            System.out.println(entity.getBody());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
