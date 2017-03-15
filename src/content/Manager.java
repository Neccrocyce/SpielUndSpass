package content;

public class Manager {
	private Poll[] polls;
	private Team[] teams;
	private Game[] games;
	
	public Manager (Game[] games, int numOfPlayers) {
		this.games = games;
		this.teams = new Team[2];
		teams[0] = new Team("Team 1", (numOfPlayers % 2) == 0 ? numOfPlayers / 2 : numOfPlayers / 2 + 1);
		teams[1] = new Team("Team 2", (numOfPlayers % 2) == 0 ? numOfPlayers / 2 : numOfPlayers / 2 + 1);
	}
}
