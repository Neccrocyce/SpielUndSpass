package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import layout.MainFrame;

public class TestWindow {
	private static MainFrame mf;
	
	@BeforeClass
	public static void init () {
		TestFrameStarter.start();		
		while (MainFrame.getInstance() == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		mf = MainFrame.getInstance();
	}

	@Test
	public void test() {
		mf.close();
		try {
			System.out.println("Closed Window");
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
	}

}
