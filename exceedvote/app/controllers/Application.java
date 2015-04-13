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
	    if(UserModel.getUser(formData.username) == null){
	    	flash("error", "Invalid Username or Password");
	    	return badRequest(index.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
	  	    
	    }
	    else{
	    	UserModel currUser = UserModel.getUser(formData.username);
	    	if(!currUser.password.equals(encodePass(formData.password))){
	    		flash("error", "Invalid Username or Password");
	    		return badRequest(index.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),Secured.isAdmin(ctx())));
	    	}
	    	else{
	    		session().clear();
	  	      	session("username", formData.username);
	  	      	return redirect(routes.Vote.index());
	    	}
	    }
	}
    
    
    @Security.Authenticated(Secured.class)
	public static Result logout() {
		session().clear();
		return redirect(routes.Application.index());
	}
    
    private static String encodePass(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

}
