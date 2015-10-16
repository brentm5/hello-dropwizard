package com.bmontague.helloworld.resources;

import com.codahale.metrics.annotation.Gauge;
import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.annotation.Counted;
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
    @Counted
    @Gauge
    public String sayHello() {
        return "Hello World";
    }
}

