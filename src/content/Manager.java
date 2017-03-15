package content;

import java.util.ArrayList;
import java.util.List;

public class Manager {
	private List<Poll> polls;
	private Team[] teams;
	private Game[] games;
	
	public Manager (Game[] games, int numOfPlayers) {
		this.polls = new ArrayList<>();
		this.games = games;
		this.teams = new Team[2];
		teams[0] = new Team("Team 1", (numOfPlayers % 2) == 0 ? numOfPlayers / 2 : numOfPlayers / 2 + 1);
		teams[1] = new Team("Team 2", (numOfPlayers % 2) == 0 ? numOfPlayers / 2 : numOfPlayers / 2 + 1);
	}
	
	/**
	 * 
	 * @param team number of Team - 0: Team 1; 1: Team 2
	 * @param name
	 */
	public void renameTeam (int team, String name) {
		teams[team].setName(name);
	}
	
	
}
