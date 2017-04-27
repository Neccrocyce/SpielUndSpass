package main;

import layout.FrameStarter;
import layout.MainFrame;
import log.MyLog;
import log.MyLogger;

public class Main implements MyLog{
	public static final String DIRECTORY = "";
	
	public static void main (String[] args) {
		MyLogger.setUp(new Main(), -1, -1);
		String[] args2 = new String[] {"8", "1200", "675"};
		new FrameStarter(args2).start();
	}
	
	public void stop () {
		MainFrame.getInstance().close();
	}
	
	public String getLogDirectory () {
		return DIRECTORY;
	}
	
	
}
