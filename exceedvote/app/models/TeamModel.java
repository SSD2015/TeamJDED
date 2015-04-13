package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class TeamModel extends Model {
	@Id
	public Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	public String teamname;
	
	public String teamdetail;
	
	public String pic;

	public static Finder<Long, TeamModel> find = new Finder<Long, TeamModel>(Long.class, TeamModel.class);

	
	
}
