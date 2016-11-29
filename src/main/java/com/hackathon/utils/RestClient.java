package com.hackathon.utils;


import com.google.gson.Gson;
import com.hackathon.lambda.SpotCheckResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.xml.bind.JAXBException;
import java.nio.charset.Charset;


/**
 * Created by guptga1 on 8/8/16.
 */

public class RestClient {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public <T> T post(String url, Object request, Class<T> responseType) {
        Client client = Client.create();

        WebResource webResource = client.resource(url);

        String input = request.toString();

        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        System.out.println("Output from Server .... \n");
        return response.getEntity(responseType);

    }

    public <T> T get(String url, Class<T> responseType) throws InterruptedException {
        Client client = Client.create();

        WebResource webResource = client.resource(url);

        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return response.getEntity(responseType);
    }

    public static void main(String[] args) throws JAXBException {
        RestClient restClient = new RestClient();
        Gson gson = new Gson();
        System.out.println(gson.toJson(restClient.post("https://i96lpa9xz4.execute-api.us-east-1.amazonaws.com/mock/mockapi", "{ \"predicted\": 1.5, \"actual\": 1.2, \"dieviations\": 0.3 }", SpotCheckResponse.class)));
    }

}
