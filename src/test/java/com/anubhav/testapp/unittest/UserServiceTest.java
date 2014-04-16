package com.anubhav.testapp.unittest;

import com.anubhav.testapp.common.ServerUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Anubhav on 4/15/2014.
 */
public class UserServiceTest {

    @Test
    public void testUserList(){
        Client client = Client.create(new DefaultClientConfig());
        WebResource service = client.resource(ServerUtils.BASE_URI);
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
        WebResource service = client.resource(ServerUtils.BASE_URI);
        ClientResponse resp = service.path("user").path("1")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        String text = resp.getEntity(String.class);
        System.out.println("Got stuff: " + text);

        assertEquals(200, resp.getStatus());
    }
}
