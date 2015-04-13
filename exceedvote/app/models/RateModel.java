package models;


import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class RateModel extends Model {
	
	@Id
	public Long id;
	
	public String teamName;
	
	public int rate;
	
	// Finder will help us easily query data from database.
	public static Finder<Long, RateModel> find = new Finder<Long, RateModel>(Long.class, RateModel.class);
	
	
}
