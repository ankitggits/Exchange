package no.sample.api;

import no.sample.api.apim.APIMInterceptor;
import no.sample.api.apim.APIMOutboundStream;
import no.sample.api.apim.APIMRequestFactory;
import no.sample.api.apim.IRestTemplateCustomizer;
import no.sample.api.interceptor.PSPRequestResponseLogger;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class HelloApplication {

   public static void main(String[] args) throws Exception {
       SpringApplication.run(HelloApplication.class, args);
   }


   @Bean
   public IRestTemplateCustomizer templateCustomizer(){
       return new IRestTemplateCustomizer() {

           private Environment environment;

           @Override
           public void setEnvironment(Environment environment) {
               this.environment = environment;
           }

           @Override
           public void customize(APIMOutboundStream stream, RestTemplate restTemplate) {
               List<ClientHttpRequestInterceptor> interceptorList = new ArrayList<>(restTemplate.getInterceptors());
               interceptorList.add(new APIMInterceptor());
               restTemplate.setInterceptors(Collections.<ClientHttpRequestInterceptor>emptyList());
               restTemplate.setRequestFactory(new APIMRequestFactory(environment, stream ,restTemplate.getRequestFactory(), interceptorList));
           }
       };
   }

   @Bean
   public RestTemplate restTemplate(IRestTemplateCustomizer customizer){
       RestTemplate restTemplate = new RestTemplate();
       restTemplate.setInterceptors(Collections.singletonList((ClientHttpRequestInterceptor) new PSPRequestResponseLogger()));
       restTemplate.setRequestFactory(getFactory());
       customizer.customize(APIMOutboundStream.TEST, restTemplate);
       return restTemplate;
   }

   public ClientHttpRequestFactory getFactory(){
        HttpComponentsClientHttpRequestFactory a = new HttpComponentsClientHttpRequestFactory();
        a.setReadTimeout(4000);
        a.setConnectTimeout(1000);
        HttpClient httpClient = httpClient();
        a.setHttpClient(httpClient);
        return new BufferingClientHttpRequestFactory(a);
   }

   public HttpClient httpClient() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setDefaultMaxPerRoute(30);
        connManager.setMaxTotal(40);
        return httpClientBuilder.setConnectionManager(connManager).build();
   }
}