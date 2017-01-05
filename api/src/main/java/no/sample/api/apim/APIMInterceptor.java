package no.sample.api.apim;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;

import java.io.IOException;
import java.net.URI;

/**
 * Created by AB75448 on 05.01.2017.
 */
public class APIMInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        System.out.println("URL in interceptor is :"+ request.getURI());
        HttpHeaders httpHeaders = request.getHeaders();
        httpHeaders.set("Ocp-Apim-Subscription-Key", "2ff63313ea324dea91a355443b10168e");
        httpHeaders.set("url", request.getURI().toString());
        URI uri = request.getURI();
        return execution.execute(request, body);
    }
}