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
	
	public UserModel(String username, String password) {
		this.username = username;
		this.password = password;
		this.isAdmin = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
