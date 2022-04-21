package sandbox.io.rest;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/")
@ApplicationScoped
public class RestController
{
	@GET
	@Path("/system/properties")
	@Produces(APPLICATION_JSON)
//	@Operation
//	(
//			summary = "Get JVM system properties for particular host",
//			description = "Retrieves and returns the JVM system properties from the system service running on the particular host."
//	)
	public Response getSystemProperties()
	{
		return Response.ok(System.getProperties()).build();
	}
}