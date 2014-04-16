package com.anubhav.testapp.unittest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.net.httpserver.HttpServer;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Anubhav on 4/15/2014.
 */
public class UserTest {

    static final URI BASE_URI = getBaseURI();

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(8080).path("TestApp").path("ws").build();
    }

    @Test
    public void testUserList(){
        Client client = Client.create(new DefaultClientConfig());
        WebResource service = client.resource(getBaseURI());
        ClientResponse resp = service.path("user").path("list")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got stuff: " + resp);
        String text = resp.getEntity(String.class);

        assertEquals(200, resp.getStatus());
    }

    @Test
    public  void testUserById(){
        Client client = Client.create(new DefaultClientConfig());
        WebResource service = client.resource(getBaseURI());
        ClientResponse resp = service.path("user").path("1")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        String text = resp.getEntity(String.class);
        System.out.println("Got stuff: " + text);

        assertEquals(200, resp.getStatus());
    }
}
