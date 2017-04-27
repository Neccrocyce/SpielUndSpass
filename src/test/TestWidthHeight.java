package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import layout.MainFrame;

public class TestWidthHeight {
	private static Pane root;
	private double delta = 20;
	
	@BeforeClass
	public static void init () {
		TestFrameStarter.start();		
		while (MainFrame.getInstance() == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		root = MainFrame.getInstance().getRoot();
	}

	@Test
	public void test() {
		testChildren(root);
	}
	
	private void testChildren (Node node) {
		Pane pane = null;
		try {
			pane = (Pane) node;
		} catch (ClassCastException e) {
			return;
		}
		List<Node> children = pane.getChildren();
		for (Node child : children) {
			Region region = null;
			try {
				region = (Region) child;
			} catch (ClassCastException e2) {
				continue;
			}
			testWidth(region.getPrefWidth(), region.getWidth(), region.getId());
			testHeight(region.getPrefHeight(), region.getHeight(), region.getId());
			testChildren (region);
		}
	}
	
	private void testWidthHeight (double prefHW, double actualHW, String id, boolean width) {
		if (prefHW < 0) {
			prefHW = actualHW;
		}
		System.out.println(id + (width ? " width" : " height")+ ": exp: " + prefHW + ", actual: " + actualHW + ", difference: " + (actualHW - prefHW));
		assertEquals(id, prefHW, actualHW, delta);
	}
	
	private void testWidth (double prefWidth, double actualWidth, String id) {
		testWidthHeight(prefWidth, actualWidth, id, true);
	}
	
	private void testHeight (double prefHeight, double actualHeight, String id) {
		testWidthHeight(prefHeight, actualHeight, id, false);
	}
	
	

}
