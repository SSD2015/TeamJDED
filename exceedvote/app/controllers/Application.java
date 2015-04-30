package controllers;



import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import views.html.index;
import play.mvc.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.jna.platform.win32.Netapi32Util.User;


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
	public static class Login {
        
        public String username;
        public String password;
        
        public String validate() {
            if(User.authenticate(username, password) == null) {
                Logger.info(username + " " + password);
                return "Invalid user or password";
            }
            return null;
        }
        
    }
	
	public static Result authenticate( ) {
	    Form<Login> loginForm = Form.form(Login.class);
	    loginForm = loginForm.bindFromRequest();
	    if (loginForm.hasErrors()) {
	         return badRequest(views.html.index.render(loginForm));
	    }

	    Login data = loginForm.get();
	    // authenticate the username using password
	    // if this fails it returns null
	    User user = User.authenticate( data.username, data.password);
	    if (user == null) {
	        flash("error", "Username or password incorrect.");
	        return badRequest(views.html.index.render(loginForm));
	    }
	    // success! Create a session for this user.
	    
	}
	
    @Security.Authenticated(Secured.class)
	public static Result logout() {
		session().clear();
		return redirect(routes.Application.index());
	}
    

}
