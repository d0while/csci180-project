package app.rest.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.RequirementComponent;
import app.entity.Requirement;

@Component
@Path("/requirements")
public class RequirementContoller {
	@Autowired
	RequirementComponent requirementComponent;

	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Requirement findById(@QueryParam("id") Long id) {
		return requirementComponent.findById(id);
	}
	
	@GET
	@Path("/listByStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Requirement> findByStudentId(@QueryParam("studentId") Long studentId){
		return requirementComponent.findByStudentId(studentId);
	}
	
	@GET
	@Path("/findAccomplishedByStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Requirement> findAccomplishedByStudentId(@QueryParam("studentId") Long studentId){
		return requirementComponent.findAccomplishedByStudentId(studentId);
	}
	
	@GET
	@Path("/countAccomplishedById")
	@Produces(MediaType.APPLICATION_JSON)
	public long countAccomplishedByStudentId(@QueryParam("studentId") Long studentId){
		return requirementComponent.countAccomplishedByStudentId(studentId);
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Requirement addRequirement(
			@QueryParam("title") String title,
			@QueryParam("instruction") String instruction,
			@QueryParam("type") String type,
			@QueryParam("due_date") String dueDate,
			@QueryParam("student_id") Long studentId,
			@QueryParam("subject_id") Long subjectId
			) {
		return requirementComponent.saveNewRequirement(title, instruction, type, dueDate, studentId, subjectId);
	}
	
	@GET
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteRequirement(@QueryParam("id") Long id) {
		return requirementComponent.deleteRequirement(id);
	}
	@GET
	@Path("/complete")
	@Produces(MediaType.TEXT_PLAIN)
	public String completeAssignment(@QueryParam("requirementId") Long id) {
		return requirementComponent.completeAssignment(id);
	}
}
