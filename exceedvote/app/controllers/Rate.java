package controllers;

import java.util.ArrayList;


import models.CriteriaModel;
import models.CriteriaRateModel;
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
		return ok(ratecriteria.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())
				,CriteriaRateModel.find.all( ),RateModel.isSuccess(localUser)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result rate(Long criteriaId){
		UserModel localUser = Secured.getUserInfo(ctx());
		return ok(rate.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())
				,TeamModel.find.all( ),CriteriaRateModel.find.byId(criteriaId),RateModel.getUser(localUser)));
	}
	
	public static Result submit(Long userid,Long criteriaId,Long teamid) {
	   
		UserModel localUser = Secured.getUserInfo(ctx());
		
		try {
			RateModel rate = Form.form(RateModel.class).bindFromRequest().get();
		    
		    
		    //update   
		    ArrayList<RateModel> rateUser = RateModel.getUser(localUser);
		    for ( RateModel   list : rateUser) {
		    	if(list.team.id == teamid && list.criteria.id == criteriaId){
		    		rate.update(list.id);
		    		return rate(criteriaId);
		    	};
			}
		    //save
		 //   if(rate.rate == null) rate.rate = 0;
		    rate.team = TeamModel.find.byId(teamid);
		    rate.criteria = CriteriaRateModel.find.byId(criteriaId);
		    rate.user = UserModel.find.byId(userid);
		    rate.save();
			// redirect to index
			return rate(criteriaId);
			
		} catch (IllegalStateException bug) {
			return rate(criteriaId);
		}
	    
	}
	



}
