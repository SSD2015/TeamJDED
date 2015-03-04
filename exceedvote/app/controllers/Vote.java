package controllers;

import play.data.Form;
import play.mvc.*;

import views.html.*;

import models.voteModel;

public class Vote extends Controller{
	public static Result addVote() {
        Vote vote = Form.form(Vote.class).bindFromRequest().get();
        vote.save();
        return ok(Vote.render(Vote.find.all()));
    }

}
