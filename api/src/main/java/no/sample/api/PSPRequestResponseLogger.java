package no.sample.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PSPRequestResponseLogger implements ClientHttpRequestInterceptor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        traceRequest(request, body);
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();        
        ClientHttpResponse response = execution.execute(request, body);
        stopWatch.stop();
        double timeTakenToFulfill=  stopWatch.getTotalTimeSeconds();
        traceResponse(response,timeTakenToFulfill);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        log.info("===========================request begin================================================");
        log.info("URI = \"{}\"" , request.getURI());
        log.info("Method = {}" , request.getMethod());
        log.info("RequestBody = \"{}\"" , new String(body, "UTF-8"));
        log.info("==========================request end================================================");
    }

    private void traceResponse(ClientHttpResponse response, double timeTaken) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        log.info("============================response begin==========================================");
        log.info("statusCode= {}" , response.getStatusCode());
        log.info("statusText= \"{}\"" , response.getStatusText());
        log.info("ResponseBody= \"{}\"" , inputStringBuilder.toString());
        log.info("Total time in seconds to get the response= {}", timeTaken);
        log.info("=======================response end=================================================");
    }
}
