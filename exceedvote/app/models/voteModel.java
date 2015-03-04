package models;

import javax.persistence.*;

import controllers.Vote;

import play.db.ebean.Model;

@Entity
public class voteModel extends Model {
	@Id
	public Long id;
	public int score;
	public String type;
	
	// Finder will help us easily query data from database.
	public static Finder<Long, Vote> find = new Finder<Long, Vote>(Long.class, Vote.class);
}
