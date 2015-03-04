package controllers;

import play.data.Form;
import play.mvc.*;

import views.html.*;

import models.voteModel;

public class Vote extends Controller{
	public static Result addVote() {
        voteModel vote = Form.form(voteModel.class).bindFromRequest().get();
        vote.save();
        return ok(Vote.render(voteModel.find.all()));
    }

}
