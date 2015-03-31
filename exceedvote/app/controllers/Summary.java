package controllers;

import models.VoteModel;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.vote;

public class Summary extends Controller {
	
	public int point = 1;
	
	//public 
	
	public static Result index(){
		return ok(vote.render(VoteModel.find.all()));
	}
}
