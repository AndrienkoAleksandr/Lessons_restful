package com.pluralsight.client;

import com.pluralsight.model.Activity;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.lang.annotation.Target;
import java.net.URI;
import java.util.List;

/**
 * Created by USER on 10.05.2014.
 */
public class ActivitySearchClient {

    private Client client;

    public ActivitySearchClient() {
        client = ClientBuilder.newClient();
    }

    public List<Activity> search(String param, List<String> paramValues,
                                 String secondParam, int secondParamValue,
                                 String thirdParam, int thirdParamValue) {
        URI uri = UriBuilder.fromUri("http://localhost:8080/webapi/").path("search/activities").build();
        WebTarget target = client.target(uri);
        List<Activity> response = target.
                queryParam(param, paramValues).
                queryParam(secondParam, secondParamValue).
                queryParam(thirdParam, thirdParamValue).
                request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {});
        System.out.println(response);
        return response;
    }
}