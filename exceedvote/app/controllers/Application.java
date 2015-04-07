package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import views.html.index;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    //For login and logout
	public static class Login {
		
		public String username;
		public String password;
		
		public String Access() {
			if (UserModel.find.where().eq("username", username).eq("password", password).findUnique() == null) {
				return "Invalid Username or Password";
			}
			return null;
		}
		
	}
	
	//TODO
/*	public static Result login() {
		return ok(index.render());
	}
	public static Result authenticate() {
		//Build login form
		Form<Login> loginForm = form(Login.class).bindFromRequest();
		if(//not success) {
			return ; //fail
		}
		else {
			//http://stackoverflow.com/questions/12075215/play-framework-using-session-for-authentication
			session("username", loginForm.get().username);
			UserModel user = UserModel.find.where().eq("username", session("username")).findUnique();
			if(isAdmin==true)
				//goto admin management page
			else //goto normal user page
			
		}
	}*/
	
	//clear session
	public static Result logout() {
		session().clear();
		return ok(index.render());
	}

}
