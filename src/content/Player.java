package content;

import java.awt.Image;

public class Player {
	private String name;
	private int score;
	private Team team;
	private Image avatar;
	
	public Player (String name, Team team, Image avatar) {
		this.name = name;
		this.team = team;
		this.avatar = avatar;
		this.score = 0;
	}
	
	public Player (String name, Team team) {
		this(name, team, null);
	}
	
	public void incScore () {
		score++;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public void setAvatar(Image avatar) {
		this.avatar = avatar;
	}
	
	public Image getAvatar() {
		return avatar;
	}
	
	@Override
	public boolean equals (Object other) {
		Player otherP = (Player) (other);
		if (this.name.equals(otherP.getName())) {
			return true;
		}
		return false;
	}
}
