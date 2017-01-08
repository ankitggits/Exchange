package no.sample.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    @RequestMapping(path = "ping")
    public ResponseEntity produce() throws URISyntaxException {
        return new ResponseEntity<String>("ping", HttpStatus.OK);
    }
}
