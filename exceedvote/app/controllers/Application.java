package controllers;



import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import views.html.index;
import play.mvc.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Application extends Controller {

	
    public static Result index() {
        return ok(index.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
    }
    
	public static Result postLogin() throws NoSuchAlgorithmException{
	    // Get the submitted form data from the request object, and run validation.
	    UserModel formData = Form.form(UserModel.class).bindFromRequest().get();

	    
	 // Hash a password for the first time
	//    String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

	    // gensalt's log_rounds parameter determines the complexity
	    // the work factor is 2**log_rounds, and the default is 10
	   // String hashed = BCrypt.hashpw("supayut.r", BCrypt.gensalt(12));

	    // Check that an unencrypted password matches one that has
	    // previously been hashed
	   
	    
	    if(UserModel.getUser(formData.username) == null){
	    	flash("error", "Invalid Username or Password");
	    	return badRequest(index.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
	  	    
	    }else{
		    UserModel currUser = UserModel.getUser(formData.username);
		    if (BCrypt.checkpw(formData.password, currUser.password)){
		    	//System.out.println("It matches");
		    	session().clear();
		      	session("username", formData.username);
		    	return redirect(routes.Vote.index());
		    }
		    else{
		    	//System.out.println("It does not match");
		    	flash("error", "Invalid Username or Password");
		    	return badRequest(index.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
		    }
	    }
	}
	
	
    
    
    @Security.Authenticated(Secured.class)
	public static Result logout() {
		session().clear();
		return redirect(routes.Application.index());
	}
    

}
