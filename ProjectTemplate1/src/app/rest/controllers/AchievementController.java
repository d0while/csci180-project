package app.rest.controllers;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.AchievementComponent;

@Component
@Path("/achievement")
public class AchievementController {
	@Autowired
	AchievementComponent achievementComponent;
	
	
}
