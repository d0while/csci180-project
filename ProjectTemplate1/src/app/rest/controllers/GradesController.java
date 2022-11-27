package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.GradesComponent;
import app.entity.Grades;

@Component
@Path("/grades")
public class GradesController {
	
	@Autowired
	GradesComponent gradesComponent;
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String listGrades(@QueryParam("studentId") long studentId) {
		return gradesComponent.listGrades(studentId);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String addGrade(@FormParam("studentId") long studentId,
							@FormParam("subjectId") long subjectId,
							@FormParam("grade") String grade) {
		return gradesComponent.saveGrade(studentId,subjectId,grade);
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String deleteGrade(@FormParam("id") long id) {
		gradesComponent.deleteGrade(id);
		return "deleted";
	}
	
	@GET
	@Path("/qpi")
	@Produces(MediaType.APPLICATION_JSON)
	public double qpiCalculator(@QueryParam("studentId") long studentId) {
		return gradesComponent.calculateQpi(studentId);
	}

	
	
}
	
	