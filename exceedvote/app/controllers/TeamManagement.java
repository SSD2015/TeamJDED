package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class TeamManagement extends Controller{
	public static Result index(){
		return ok(teammanagement.render());
	}
	
	public static Result addteam() {
		return ok(addteam.render());
	}
}
