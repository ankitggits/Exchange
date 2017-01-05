package no.sample.api.apim;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

/**
 * Created by AB75448 on 05.01.2017.
 */
public class APIMRequestFactory extends InterceptingClientHttpRequestFactory {

    private String url;

    public APIMRequestFactory(Environment environment , APIMOutboundStream stream, ClientHttpRequestFactory requestFactory, List<ClientHttpRequestInterceptor> interceptors) {
        super(requestFactory, interceptors);
        this.url = stream.getURI(environment);
    }

    @Override
    protected ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod, ClientHttpRequestFactory requestFactory) {
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return super.createRequest(uri, httpMethod, requestFactory);
    }
}
