package com.github.knextsunj.homebank.colorcardmaster.restclient;

import com.github.knextsunj.homebank.colorcardmaster.exception.ValidationServiceInvocationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class BusinessRuleEngineClient {

    private static final Logger logger = LogManager.getLogger(BusinessRuleEngineClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public boolean executeDeDup(String name)  {

        boolean status = false;

        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://localhost:9081/colorcardbusinessrule/dedup/");
            stringBuilder.append(name);
            URI uri = new URI(stringBuilder.toString());

            status = restTemplate.postForObject(uri, null, Boolean.class);
            logger.info("The status is :{}",status);
        } catch (URISyntaxException uriSyntaxException) {
            logger.error("URI syntax incorrect. Exception is : {}", uriSyntaxException);
            throw new ValidationServiceInvocationException(uriSyntaxException.getMessage());
        } catch (RestClientException restClientException) {
            logger.error("Exception when invoking remote business service : {}", restClientException);
            throw new ValidationServiceInvocationException(restClientException.getMessage());
        }

        return status;
    }
}
