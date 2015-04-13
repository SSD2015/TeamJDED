package controllers;

import models.UserModel;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;


public class Secured extends Security.Authenticator {

  @Override
  public String getUsername(Context ctx) {
    return ctx.session().get("username");
  }

  @Override
  public Result onUnauthorized(Context context) {
    return redirect(routes.Application.index()); 
  }
  
  public static String getUser(Context ctx) {
    return ctx.session().get("username");
  }
  
  public static boolean isLoggedIn(Context ctx) {
    return (getUser(ctx) != null);
  }
  
  public static boolean isAdmin(Context ctx) {
	  	
	    return (getUser(ctx)!= null ? UserModel.getUser(getUser(ctx)).isAdmin : false);
  }
  
  public static UserModel getUserInfo(Context ctx) {
    return (isLoggedIn(ctx) ? UserModel.getUser(getUser(ctx)) : null);
  }

}
