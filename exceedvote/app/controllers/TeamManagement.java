package controllers;

import models.TeamModel;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import play.mvc.*;
import play.data.Form;
import play.mvc.Security;


public class TeamManagement extends Controller{
	
	@Security.Authenticated(Secured.class)
	public static Result index(){
		return ok(teammanagement.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result addteam() {
		return ok(addteam.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
	}
	
	public static Result record(){
		TeamModel team = Form.form(TeamModel.class).bindFromRequest().get();
		
		team.save();
		
		return index();
	}
}
