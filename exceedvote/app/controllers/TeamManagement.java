package controllers;

import models.TeamModel;
import views.html.*;
import play.mvc.*;
import play.data.Form;

public class TeamManagement extends Controller {
	public static Result index(){
		return ok(teammanagement.render());
	}
	
	public static Result AddInform(){
		TeamModel team = Form.form(TeamModel.class).bindFromRequest().get();
		
		team.save();
		
		return index();
	}
}
