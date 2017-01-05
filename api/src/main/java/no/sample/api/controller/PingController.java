package no.sample.api.controller;

import no.sample.api.apim.APIMRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by AB75448 on 21.12.2016.
 */
@RestController
public class PingController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(path = "produce")
    public ResponseEntity produce() throws URISyntaxException {
        testAspect();
        RequestEntity<String> requestEntity = new RequestEntity<String>(HttpMethod.GET, new URI("http://abcd"));
        ResponseEntity<String> result = restTemplate.exchange(requestEntity, String.class);
        return new ResponseEntity<String>(result.getBody(), HttpStatus.OK);
    }

    @RequestMapping(path = "consume")
    public ResponseEntity consume(@RequestHeader("Ocp-Apim-Subscription-Key") String customHeader, @RequestHeader("url") String url){
        System.out.println("URL: "+ url);
        System.out.println("Ocp-Apim-Subscription-Key: "+ customHeader);
        return new ResponseEntity<String>("URL: "+url +" and Ocp-Apim-Subscription-Key: "+customHeader, HttpStatus.OK);
    }

    @APIMRestTemplate
    public String testAspect(){
        return "hiiiiii";
    }



}
