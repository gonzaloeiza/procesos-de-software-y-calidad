package p2parking.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/prueba")
@Produces(MediaType.APPLICATION_JSON)
public class MainServer {
	
// localhost:8080/api/prueba/test
	@GET
	@Path("/test")
	public Response addDonation() {
		return Response.ok("funcionando").build();
	}
}