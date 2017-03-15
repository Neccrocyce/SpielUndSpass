package content;

import java.util.ArrayList;
import java.util.List;

public class Poll {
	private String question;
	private List<Answer> answers;
	
	public Poll (String question) {
		this.question = question;
		answers = new ArrayList<>();
	}
	
	public void addAnswer (String answer, Player player) {
		answers.add(new Answer(answer, player));
	}
	
	public String getQuestion() {
		return question;
	}
	
	public Answer[] getAnswers () {
		return answers.toArray(new Answer[answers.size()]);
	}
	
	
	public class Answer {
		private String answer;
		private Player player;
		
		public Answer (String answer, Player player) {
			this.answer = answer;
			this.player = player;
		}
		
		public String getAnswer() {
			return answer;
		}
		
		public Player getPlayer() {
			return player;
		}
	}
}
