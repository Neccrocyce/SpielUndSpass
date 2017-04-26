package content;

public class Team {
	private String name;
	private Player[] players;
	private int victoryPoints;
	private int numPlayers;
	
	public Team (String name, int numOfPlayers) {
		this.name = name;
		players = new Player[numOfPlayers];
		numPlayers = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	/**
	 * 
	 * @param newPlayer
	 * @return true if player was added to the team - false if another player exists with the same name
	 * @throws IllegalStateException if the maximum number of players has been reached already
	 */
	public boolean addPlayer (Player newPlayer) {
		if (numPlayers == players.length) {
			throw new IllegalStateException("Maximum Number of Players reached, already");
		}
		for (Player player : players) {
			if (newPlayer.equals(player)) {
				return false;
			}
		}
		players[numPlayers] = newPlayer;
		numPlayers++;
		return true;
	}
	
	public int getVictoryPoints() {
		return victoryPoints;
	}
	
	public void incVictoryPoints () {
		victoryPoints++;
	}
	
	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	
	/**
	 * 
	 * @return the summarized score of all players in this team
	 */
	public int getSumOfScore () {
		int score = 0;
		for (Player player : players) {
			score += player.getScore();
		}
		return score;
	}
}
