package models;


import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class CriteriaModel extends Model {
	
	@Id
	public Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	public String criName;
	
	// Finder will help us easily query data from database.
	public static Finder<Long, CriteriaModel> find = new Finder<Long, CriteriaModel>(Long.class, CriteriaModel.class);
	
	
}
