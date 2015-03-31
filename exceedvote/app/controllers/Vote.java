package controllers;

import models.VoteModel;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Vote extends Controller{

	public static Result index(){
		return ok(vote.render());
	}
	
	public static Result voteItem() {
	    // map data from HTTP request to an object.
	    VoteModel voter = Form.form(VoteModel.class).bindFromRequest().get();
	    // save it to database.
	    voter.save();
		// redirect to index
		return index();
	}
	
	public static Result teamdetail() {
		return ok(teamdetail.render());
	}


}
