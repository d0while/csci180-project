package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.TeacherComponent;
import app.entity.Teacher;

@Component
@Path("/teachers")
public class TeacherController {
	
	@Autowired
	TeacherComponent teacherComponent;
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Teacher> listTeachers() {
		return teacherComponent.listTeachers();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher addTeacher(@FormParam("name") String name,
							@FormParam("email") String email,
							@FormParam("consultation_hours") String consultation_hours) {
		return teacherComponent.addTeacher(name,email,consultation_hours);
	}
	
	@POST
	@Path("delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String deleteTeacher(@FormParam("id") long id) {
		String output = teacherComponent.deleteTeacher(id);
		return output;
	}
	
}
	
	