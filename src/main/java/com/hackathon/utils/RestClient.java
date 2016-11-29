package com.hackathon.utils;


import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;


/**
 * Created by guptga1 on 8/8/16.
 */

public class RestClient {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    public static final RestTemplate restTemplate;
    public static final RetryTemplate retryTemplate;

    static {
        restTemplate = getRestTemplate();
        retryTemplate = getRetryTemplate();
    }

    public <T> ResponseEntity<T> post(String url, Object request, Class<T> responseType) throws JAXBException {
        String requestStr = serialize(request);
        ResponseEntity<T> responseEntity = retryTemplate.execute(new RetryCallback<ResponseEntity<T>, RuntimeException>() {
            public ResponseEntity<T> doWithRetry(RetryContext context) {
                return restTemplate.postForEntity(url, requestStr, responseType);
            }
        });
        return responseEntity;
    }

    public <T> ResponseEntity<T> get(String url, Class<T> responseType) throws InterruptedException {
        ResponseEntity<T> responseEntity = retryTemplate.execute(new RetryCallback<ResponseEntity<T>, RuntimeException>() {
            public ResponseEntity<T> doWithRetry(RetryContext context) {
                return restTemplate.getForEntity(url, responseType);
            }

        });
        return responseEntity;
    }

    private static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new TextHtmlHttpMessageConverter());
        return restTemplate;
    }

    private static RetryTemplate getRetryTemplate() {
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(500);
        RetryTemplate template = new RetryTemplate();
        template.setRetryPolicy(retryPolicy);
        template.setBackOffPolicy(backOffPolicy);
        return template;
    }

    public static class TextHtmlHttpMessageConverter extends Jaxb2RootElementHttpMessageConverter {
        public TextHtmlHttpMessageConverter() {
            List<MediaType> types = Arrays.asList(
                    new MediaType("text", "html", DEFAULT_CHARSET),
                    new MediaType("application", "xml", DEFAULT_CHARSET),
                    new MediaType("application", "*+xml", DEFAULT_CHARSET)
            );
            super.setSupportedMediaTypes(types);
        }
    }

    private static String serialize(Object obj) throws JAXBException {
        if (obj == null) {
            return "null";
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(obj, stringWriter);
        return stringWriter.toString().replaceAll(":ns2","").replaceAll("ns2:","");
    }

}
