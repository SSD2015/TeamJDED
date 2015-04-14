package controllers;

import java.util.ArrayList;

import models.CriteriaModel;
import models.RateModel;
import models.TeamModel;
import models.UserModel;
import models.VoteModel;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import play.mvc.Security;


public class Rate extends Controller{
	
	@Security.Authenticated(Secured.class)
	public static Result index(){
		UserModel localUser = Secured.getUserInfo(ctx());
		return ok(rate.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())
				,TeamModel.find.all(),RateModel.getUser(localUser)));
	}
	
	public static Result submit(Long userid,Long teamid) {
	   
		UserModel localUser = Secured.getUserInfo(ctx());
	    RateModel rate = Form.form(RateModel.class).bindFromRequest().get();
	    
	    
	    //update   
	    ArrayList<RateModel> rateUser = RateModel.getUser(localUser);
	    for ( RateModel   list : rateUser) {
	    	if(list.team.id == teamid){
	    		rate.update(list.id);
	    		return index();
	    	};
		}
	    //save
	    rate.team = TeamModel.find.byId(teamid);
	    rate.user = UserModel.find.byId(userid);
	    rate.save();
		// redirect to index
		return index();
	}
	



}
