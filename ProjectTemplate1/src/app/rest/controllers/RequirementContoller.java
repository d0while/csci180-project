package app.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.RequirementComponent;

@Component
@Path("/requirements")
public class RequirementContoller {
	@Autowired
	RequirementComponent requirementComponent;

}
