package app.rest.controllers;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import app.components.StudentComponent;
import app.entity.Student;
import app.repositories.UploadedFileRepository;

@Component
@Path("/students")
public class StudentController {
	
	
	@Autowired
	StudentComponent studentComponent;
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> listStudents (){
		return studentComponent.listStudents();
	}
	
	@GET
	@Path("/findById")
	@Produces(MediaType.APPLICATION_JSON)
	public Student findById (@QueryParam("id") long id){
		return studentComponent.findById(id);
	}
	
	@GET
	@Path("/findByName")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> findByName (@QueryParam("name") String nameQuery){
		return studentComponent.findByName(nameQuery);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Student addStudent(@FormParam("name") String name, @FormParam("email") String email) {
		return studentComponent.saveStudent(name, email);
	}
	
	@GET
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteStudent(@QueryParam("id") long id) {
		return studentComponent.deleteStudent(id);
	}	
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String upload(@FormDataParam("file") InputStream uploadedInputStream,
            			 @FormDataParam("file") FormDataContentDisposition fileDetails,
            			 @FormDataParam("id") long id)
	{
		logger.info("Receiving file: "+fileDetails.getFileName());
		return studentComponent.saveFile(uploadedInputStream, fileDetails.getFileName(),  id);
	}

	
	@GET
	@Path("/image")
	@Produces("image/jpeg")
	public byte[] getImage(@QueryParam("id") Long imageId) throws Exception
	{
		return studentComponent.getImageFile(imageId);
	}
	
	
}
