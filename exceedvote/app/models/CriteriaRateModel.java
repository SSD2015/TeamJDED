package models;


import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class CriteriaRateModel extends Model {
	
	@Id
	public Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	public String criName;
	
	// Finder will help us easily query data from database.
	public static Finder<Long, CriteriaRateModel> find = new Finder<Long, CriteriaRateModel>(Long.class, CriteriaRateModel.class);
	
	
}
