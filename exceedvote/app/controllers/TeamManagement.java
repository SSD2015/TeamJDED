package controllers;

<<<<<<< HEAD
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class TeamManagement extends Controller{
=======
import play.mvc.Result;
import views.html.*;

public class TeamManagement {
>>>>>>> a631c123066400900ac7856ffd3929a87382a01f
	public static Result index(){
		return ok(teammanagement.render());
	}
	
	
}
