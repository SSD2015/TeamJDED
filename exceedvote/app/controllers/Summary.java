package controllers;

import models.VoteModel;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.summaryscore;
import play.mvc.Security;

public class Summary extends Controller {
	

	public int point = 1;
	
	@Security.Authenticated(Secured.class)
	public static Result index(){
		return ok(summaryscore.render(VoteModel.options(),Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
	}
}
