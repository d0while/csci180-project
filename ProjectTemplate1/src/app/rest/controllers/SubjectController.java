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

import app.components.SubjectComponent;
import app.entity.Subject;

@Component
@Path("/subjects")
public class SubjectController {
	
	@Autowired
	SubjectComponent subjectComponent;
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Subject> listSubjects() {
		return subjectComponent.listSubjects();
	}
	
	@GET
	@Path("/listbystudentid")
	@Produces(MediaType.APPLICATION_XML)
	public List<Subject> listSubjectsById(@QueryParam("studentId") Long studentId) {
		return subjectComponent.listSubjectsById(studentId);
	}
	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Subject addSubject(@FormParam("title") String title,
							@FormParam("schedule") String schedule,
							@FormParam("teacherId") Long teacherId,
							@FormParam("units") int units,
							@FormParam("studentId") Long student_id) {
		return subjectComponent.addSubject(title, schedule, teacherId, units, student_id);
	}

	@POST
	@Path("delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String deleteSubject(@FormParam("id") long id) {
		String output = subjectComponent.deleteSubject(id);
		return output;
	}
	
}
	
	