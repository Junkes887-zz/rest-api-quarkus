package org.acme.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private Response.ResponseBuilder builder;

    public Response get() {
        Client client = ClientBuilder.newBuilder()
                .executorService(executorService)
                .build();

        return client.target("https://mocki.io/v1/39b379ff-c468-4ad7-9d5f-7c19c22da5ee")
                .request()
                .get(Response.class);
    }
}
