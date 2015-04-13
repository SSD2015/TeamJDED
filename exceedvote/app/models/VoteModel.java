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
	

	public static Map<String,Integer> options() {
        LinkedHashMap<String,Integer> options = new LinkedHashMap<String,Integer>();
        int teamA = 0,teamB = 0,teamC = 0,teamD = 0 ;
        /*  
        for(VoteModel c: VoteModel.find.orderBy("name").findList()) {
           String str = ""+c.name;
        	if (str.equals("a")) teamA++;
            else if(c.name.equals("b")) teamB++;
            	else if(c.name.equals("c")) teamC++;
            		else if(c.name.equals("d"))teamD++;
        	
        	//options.put(c.id.toString(), c.name);
        }
        */
        options.put("teamA", teamA);
        options.put("teamB", teamB);
        options.put("teamC", teamC);
        options.put("teamD", teamD);
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
