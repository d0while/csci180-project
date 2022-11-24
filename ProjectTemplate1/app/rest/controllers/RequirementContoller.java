package app.rest.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
//import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.components.RequirementComponent;
import app.components.RequirementDto;
import app.entity.Requirement;

@Component
@Path("/requirements")
public class RequirementContoller {
    @Autowired
    RequirementComponent requirementComponent;

    @GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Requirement> listRequirements (){
		return requirementComponent.listRequirements();
	}
	
	@GET
	@Path("/listBySubject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Requirement> findByName (@QueryParam("name") String nameQuery){
		return requirementComponent.listRequirementsbySubject(nameQuery);
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Requirement addRequirement(RequirementDto dto) {
		return requirementComponent.saveRequirement(dto);
	}
	
	@GET
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteRequirement(@QueryParam("id") Long id) {
		return requirementComponent.deleteRequirement(id);
	}	

}
