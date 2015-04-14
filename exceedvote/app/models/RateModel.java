package models;


import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class RateModel extends Model {
	
	@Id
	public Long id;
	
	@ManyToOne
	public UserModel user;
	
	@ManyToOne
	public TeamModel team;	
	
	public int	rate;
	
	// Finder will help us easily query data from database.
	public static Finder<Long, RateModel> find = new Finder<Long, RateModel>(Long.class, RateModel.class);
	
	public static ArrayList<RateModel> getUser(UserModel localUser) {
        ArrayList<RateModel> options = new ArrayList<RateModel>();
        for(RateModel info: RateModel.find.where().ilike("user_id", localUser.id+"").findList()) {
            	options.add(info);
        	
        }
        
        return options;
    }
}
