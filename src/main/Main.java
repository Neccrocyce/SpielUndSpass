package main;

import layout.FrameStarter;
import layout.MainFrame;

public class Main {
	public static void main (String[] args) {
		MainFrame.setNumOfPlayers(8);
		new FrameStarter(args).start();
		
//		while (MainFrame.getInstance() == null) {
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//			}
//		}
//		MainFrame.getInstance().setScore(0, 30000);
	}
}
