package com.bmontague.helloworld.resources;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-world/v1/")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    public HelloWorldResource() { }

    @GET
    @Timed
    public String sayHello() {
        return "Hello World";
    }
}

