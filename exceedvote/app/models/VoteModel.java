package models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class VoteModel extends Model {
	
	@Id
	public Long id;
	
	@ManyToOne
	public UserModel user;
	
	@ManyToOne
	public CriteriaModel criteria;
	
	@ManyToOne
	public TeamModel team;	
	
	
	// Finder will help us easily query data from database.
	public static Finder<Long, VoteModel> find = new Finder<Long, VoteModel>(Long.class, VoteModel.class);
	

	public static ArrayList<VoteModel> getUser(UserModel localUser) {
        ArrayList<VoteModel> options = new ArrayList<VoteModel>();
        for(VoteModel info: VoteModel.find.where().ilike("user_id", localUser.id+"").findList()) {
            	options.add(info);
        	
        }
        
        return options;
    }
	
	public static Map<String,String> options2() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        
        for(VoteModel c: VoteModel.find.orderBy("name").findList()) {
      //  	String str = ""+c.name;
      //  		options.put(c.id.toString(), str);
        }
       
        return options;
    }

}
