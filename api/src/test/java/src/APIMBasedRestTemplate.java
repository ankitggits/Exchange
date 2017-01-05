package src;

import no.sample.api.apim.APIMInterceptor;
import no.sample.api.apim.APIMRequestFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * Created by AB75448 on 05.01.2017.
 */
public class APIMBasedRestTemplate extends RestTemplate{

    public APIMBasedRestTemplate(RestTemplate restTemplate){
        super();
        List<ClientHttpRequestInterceptor> interceptorList = restTemplate.getInterceptors();
        if(interceptorList!=null && interceptorList.size()>0){
            interceptorList.add(new APIMInterceptor());
        }else{
            interceptorList = Collections.singletonList((ClientHttpRequestInterceptor) new APIMInterceptor());
        }
        this.setInterceptors(interceptorList);
        this.setRequestFactory(new APIMRequestFactory(restTemplate.getRequestFactory()));
        this.setErrorHandler(restTemplate.getErrorHandler());
        this.setMessageConverters(restTemplate.getMessageConverters());
    }

    public APIMBasedRestTemplate(){
        super();
        this.setInterceptors(Collections.singletonList((ClientHttpRequestInterceptor) new APIMInterceptor()));
        this.setRequestFactory(new APIMRequestFactory(getFactory()));
    }

    public ClientHttpRequestFactory getFactory(){
        HttpComponentsClientHttpRequestFactory a = new HttpComponentsClientHttpRequestFactory();
        a.setReadTimeout(4000);
        a.setConnectTimeout(1000);
        HttpClient httpClient = tspHttpClient();

        a.setHttpClient(httpClient);
        return new BufferingClientHttpRequestFactory(a);
    }

    public HttpClient tspHttpClient() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setDefaultMaxPerRoute(30);
        connManager.setMaxTotal(40);
        return httpClientBuilder.setConnectionManager(connManager).build();
    }

}
