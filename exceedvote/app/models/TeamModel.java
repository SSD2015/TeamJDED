package models;

public class TeamModel {
	public String teamname;
	
	public String teamdescription;
	
	public String pic;

	
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
