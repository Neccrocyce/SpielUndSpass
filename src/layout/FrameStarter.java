package layout;

public class FrameStarter extends Thread {
	String[] args;
	
	public FrameStarter (String[] args) {
		this.args = args;
	}
	
	public void run() {
		MainFrame.initialize(args);
	}
}
