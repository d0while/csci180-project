package app.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.AchievementComponent;

@Component
@Path("/achievements")
public class AchievementController {
	@Autowired
	AchievementComponent achievementComponent;
	
	@GET
	@Path("/my_achievements")
	@Produces(MediaType.TEXT_PLAIN)	
	public String getMyAchievements(@QueryParam("student_id") Long studentId) {
		return achievementComponent.getMyAchievements(studentId);
	}
}
