package ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RestController {

	@POST
	@Path("/sample")
	@Consumes({MediaType.APPLICATION_JSON})
	public String sampleRestAPI() {
		
		return "Hello World!";
	}
	
	@GET
	@Path("/sample2")
	public String sample2() {
		return "Sample2";
	}
}
