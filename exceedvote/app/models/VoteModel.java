package models;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class VoteModel extends Model {
	
	@Id
	public Long id;
	
	public int score;
	
	public String name;
	
	// Finder will help us easily query data from database.
	public static Finder<Long, VoteModel> find = new Finder<Long, VoteModel>(Long.class, VoteModel.class);
}
