package controllers;

import play.mvc.Controller;
import play.mvc.*;

import views.html.*;

public class Vote extends Controller{
	public static Result index(){
		return ok(vote.render("Vote Page"));
	}

}
