package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model.Finder;

@Entity
public class TeamModel {
	@Id
	public int id;
	
	public int score;
	
	public String name;
	
	public String teamdescription;
	
	public String pic;

	public static Finder<Long, TeamModel> find = new Finder<Long, TeamModel>(Long.class, TeamModel.class);
	
	
}
