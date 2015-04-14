package controllers;

import static play.data.Form.form;
import models.CriteriaModel;
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
		return ok(management.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())
				,TeamModel.find.all(),CriteriaModel.find.all()));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result addteam() {
		return ok(addteam.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result editteam(Long id) {
		
		Form<TeamModel> teamForm = form(TeamModel.class).fill(
	            TeamModel.find.byId(id)
	        );
	        return ok(
	            editteam.render(id, teamForm,Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx()))
	        );
	}
	
	public static Result recordTeam(){
		TeamModel team = Form.form(TeamModel.class).bindFromRequest().get();
		
		team.save();
		
		return index();
	}
	
	public static Result updateTeam(Long id ){
		Form<TeamModel> teamForm = form(TeamModel.class).bindFromRequest();
        if(teamForm.hasErrors()) {
            return badRequest(editteam.render(id, teamForm,Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
        }
        teamForm.get().update(id);
        
        //flash("success", "Team " + teamForm.get().name + " has been updated");
		
		return index();
	}
	
	public static Result deleteTeam(Long id){
		TeamModel.find.ref(id).delete();
		
		return index();
	}
	
	
	public static Result recordCriteria(){
		CriteriaModel criteria = Form.form(CriteriaModel.class).bindFromRequest().get();
		
		criteria.save();
		
		return index();
	}
	
	public static Result updateCriteria(Long id ){
		Form<CriteriaModel> criForm = form(CriteriaModel.class).bindFromRequest();
        if(criForm.hasErrors()) {
            return index();
        }
        criForm.get().update(id);
        
        //flash("success", "Team " + teamForm.get().name + " has been updated");
		
		return index();
	}
	
	public static Result deleteCriteria(Long id){
		CriteriaModel.find.ref(id).delete();
		
		return index();
	}
}
