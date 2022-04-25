package sandbox.io.rest;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/")
@ApplicationScoped
public class RestController
{
	@Inject private RestService service;

	@GET
	@Path("/system/properties")
	@Produces(APPLICATION_JSON)
	public Response getSystemProperties()
	{
		return Response.ok(service.getSystemProperties()).build();
	}

	@GET
	@Path("/system/timestamp")
	@Produces(TEXT_PLAIN)
	public Response getSystemTimestamp()
	{
		return Response.ok(service.getTimestamp()).build();
	}

	@POST
	@Path("/event/create")
	@Produces(APPLICATION_JSON)
	@Transactional
	public Response createEventAndGetList()
	{
		return Response.ok(service.createEventAndGetList()).build();
	}
}