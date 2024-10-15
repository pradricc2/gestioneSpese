package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestController {
    @GET
    public Response test() {
        return Response.ok("JAX-RS is working!").build();
    }
}

