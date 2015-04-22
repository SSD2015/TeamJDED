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
	
	public static Map<String,String[]> getSummary() {
		
        LinkedHashMap<String,String[]> options = new LinkedHashMap<String,String[]>();
        ArrayList<CriteriaModel> criterias = new ArrayList<CriteriaModel>();
        ArrayList<TeamModel> teams = new ArrayList<TeamModel>();
        for (CriteriaModel c: CriteriaModel.find.orderBy("id").findList()){
        	criterias.add(c);
        }
        for (TeamModel t: TeamModel.find.orderBy("id").findList()){
        	teams.add(t);
        }
        int numCri = criterias.size();
        int numTeam = teams.size();
        
        for(int i = 0;i < numCri;i++){
        	for(int j = 0; j < numTeam;j++){
	        	String[] info = new String[3];
	        	info[0] = CriteriaModel.find.where().eq("id", criterias.get(i).id.toString()).findUnique().criName;
	        	info[1] = TeamModel.find.where().eq("id",teams.get(j).id.toString()).findUnique().teamname;
	        	info[2] = VoteModel.find.where().eq("criteria_id", criterias.get(i).id.toString()).eq("team_id", teams.get(j).id.toString())
						.findRowCount()+"";
	        	String criName = info[0]+info[1];
	        	options.put( criName, info);
	        //	options.put(i+" "+j,info);
        	}
        }
        /*
        for(VoteModel c: VoteModel.find.orderBy("name").findList()) {
      //  	String str = ""+c.name;
      //  		options.put(c.id.toString(), str);
        }
       */
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
