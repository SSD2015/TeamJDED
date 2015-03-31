package controllers;

import play.mvc.Result;
import views.html.*;

public class TeamManagement {
	public static Result index(){
		return ok(teammanagement.render());
	}
	
	
}
