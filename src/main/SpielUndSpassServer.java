package main;

import layout.FrameStarter;
import layout.MainFrame;
import log.MyLog;
import log.MyLogger;

public class SpielUndSpassServer implements MyLog{
	public static final String DIRECTORY = "";
	
	public static void main (String[] args) {
		MyLogger.setUp(new SpielUndSpassServer(), -1, 10, "");
		MyLogger.rotate();
		MyLogger.logInfo("Start: Initializing Server");
		String[] args2 = new String[] {"8", "1200", "675"};
		new FrameStarter(args2).start();
		
		MyLogger.logInfo("Finished: Initializing Server");
	}
	
	@Override
	public void stop () {
		MainFrame.getInstance().close();
	}

	@Override
	public void sendErrMsg(String msg) {
		System.err.println(msg);		
	}

	@Override
	public void sendLog(String msg) {
		System.out.println(msg);
	}	
	
}
