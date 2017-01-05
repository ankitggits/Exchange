package no.sample.api.apim;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by AB75448 on 05.01.2017.
 */

@Aspect
public class RestTemplateAspect {

    private Environment environment;

    public RestTemplateAspect(Environment environment){
        this.environment = environment;
    }

    @AfterReturning(pointcut = "@annotation(no.sample.api.apim.APIMRestTemplate)", returning= "restTemplate")
    public void addCustomHeaderAndURI(RestTemplate restTemplate) {
        List<ClientHttpRequestInterceptor> interceptorList = new ArrayList<>(restTemplate.getInterceptors());
        interceptorList.add(new APIMInterceptor());
        restTemplate.setInterceptors(Collections.<ClientHttpRequestInterceptor>emptyList());
        restTemplate.setRequestFactory(new APIMRequestFactory(environment, APIMOutboundStream.TEST ,restTemplate.getRequestFactory(), interceptorList));
    }

    @Before("@annotation(no.sample.api.apim.APIMRestTemplate)")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name);
    }


}
