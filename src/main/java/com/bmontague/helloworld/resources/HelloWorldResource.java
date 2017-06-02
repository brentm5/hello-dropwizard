package com.bmontague.helloworld.resources;

import com.bmontague.helloworld.models.Hello;
import com.codahale.metrics.annotation.Gauge;
import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.annotation.Counted;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/hello-world/v1")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private Hello helloObj;

    public HelloWorldResource(String name) {
      this.helloObj = new Hello(name);
    }

    @GET
    @Timed
    @Counted
    @Gauge
    @Path("/hello")
    public Response sayHello() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("http://localhost:8080/hello-world/v1/name")
                .build();

        okhttp3.Response response = client.newCall(request).execute();

        String name = response.body().string().toString();
        return Response.ok().type(MediaType.TEXT_PLAIN).entity("Hello " + name + "!!").build();
    }

    @GET
    @Timed
    @Counted
    @Gauge
    @Path("/name")
    public Response getName() {
        return Response.ok().type(MediaType.TEXT_PLAIN).entity(helloObj.getName()).build();
    }

    @GET
    @Timed
    @Counted
    @Gauge
    public Response getRoot() {
        return Response.ok().type(MediaType.APPLICATION_JSON_TYPE).entity(helloObj).build();
    }
}

