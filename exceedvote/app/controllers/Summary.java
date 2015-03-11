package controllers;

import models.VoteModel;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.summaryscore;

public class Summary extends Controller {
	
	public int point =1;
	
	public static Result index(){
		return ok(summaryscore.render(VoteModel.find.all()));
	}
}
