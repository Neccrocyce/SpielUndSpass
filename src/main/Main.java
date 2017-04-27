package main;

import layout.FrameStarter;

public class Main {
	public static void main (String[] args) {
		String[] args2 = new String[] {"8", "1200", "675"};
		new FrameStarter(args2).start();
//		while (MainFrame.getInstance() == null) {
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//			}
//		}
//		MainFrame.getInstance().setScore(0, 30000);
	}
}
