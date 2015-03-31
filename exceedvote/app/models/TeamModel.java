package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model.Finder;

@Entity
public class TeamModel {
	@Id
	public int id;
	
	public String teamname;
	
	public String teamdescription;
	
	public String pic;

	public static Finder<Long, TeamModel> find = new Finder<Long, TeamModel>(Long.class, TeamModel.class);
	
	public TeamModel(String teamname, String teamdescription , String pic) {
		this.teamname = teamname;
		this.teamdescription = teamdescription;
		this.pic = pic;
	}
	
	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getTeamdescription() {
		return teamdescription;
	}

	public void setTeamdescription(String teamdescription) {
		this.teamdescription = teamdescription;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
