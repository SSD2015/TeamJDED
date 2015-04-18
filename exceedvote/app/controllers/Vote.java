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


public class Vote extends Controller{
	
	@Security.Authenticated(Secured.class)
	public static Result index(){
		UserModel localUser = Secured.getUserInfo(ctx());
		return ok(criteria.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())
				,CriteriaModel.find.all( ),VoteModel.getUser(localUser)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result vote(Long criteriaId){
		UserModel localUser = Secured.getUserInfo(ctx());
		return ok(vote.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())
				,TeamModel.find.all( ),CriteriaModel.find.byId(criteriaId),VoteModel.getUser(localUser)));
	}
	
	public static Result voteItem(Long userId,Long criteriaId, Long teamId) {
	    
		UserModel localUser = Secured.getUserInfo(ctx());
	    VoteModel voter = Form.form(VoteModel.class).bindFromRequest().get();
	    
	    
	  //update   
	    ArrayList<VoteModel> voteUser = VoteModel.getUser(localUser);
	    for ( VoteModel   list : voteUser) {
	    	if(list.criteria.id == criteriaId){
	    		voter.team = TeamModel.find.byId(teamId);
	    		voter.update(list.id);
	    		return index();
	    	};
		}
	    
	    voter.user = UserModel.find.byId(userId);
	    voter.criteria = CriteriaModel.find.byId(criteriaId);
	    voter.team = TeamModel.find.byId(teamId);
	    voter.save();
		// redirect to index
		return index();
	}
	



}
