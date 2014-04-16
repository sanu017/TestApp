package com.anubhav.testapp.common;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by Anubhav on 4/16/2014.
 */
public class ServerUtils {

    public static final URI BASE_URI = getBaseURI();

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(8080).path("TestApp").path("ws").build();
    }
}
