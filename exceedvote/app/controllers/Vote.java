package controllers;

import models.VoteModel;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import play.mvc.Security;


public class Vote extends Controller{
	
	@Security.Authenticated(Secured.class)
	public static Result index(){
		return ok(vote.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
	}
	
	public static Result voteItem() {
	    // map data from HTTP request to an object.
	    VoteModel voter = Form.form(VoteModel.class).bindFromRequest().get();
	    // save it to database.
	    voter.save();
		// redirect to index
		return index();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result teamdetail() {
		return ok(teamdetail.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
	}


}
