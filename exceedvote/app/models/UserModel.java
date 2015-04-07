package models;


import javax.persistence.*;

import play.db.ebean.Model.Finder;


@Entity
public class UserModel {
	@Id
	public Long id;
	
	public String username;
	
	public String password;
	
	public String name;
	
	public boolean isAdmin;
	
	public static Finder<Long, UserModel> find = new Finder<Long, UserModel>(Long.class, UserModel.class);
	
	
}
