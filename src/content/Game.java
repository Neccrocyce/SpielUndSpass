package content;

import java.awt.Image;

public class Game {
	private String title;
	private String[] contents;
	private Image[] images;
	private String[] gmNotes;
	private int indexContents;
	private int indexImages;
	boolean[] showContent;
	
	public Game (String title, String[] content, Image[] images, boolean[] showContent) {
		this.title = title;
		this.contents = content;
		this.images = images;
		this.showContent = showContent;
	}
	
	public Game (String title, String[] content) {
		this(title, content, null, new boolean[0]);
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean isNextContent () {
		if (images == null) {
			return true;
		}
		return showContent[indexContents + indexImages];
	}
	
	public String getNextContent () {
		indexContents++;
		return contents[indexContents - 1];
	}
	
	public Image getNextImage () {
		indexImages++;
		return images[indexImages - 1];
	}
	
	public String[] getGmNotes() {
		return gmNotes;
	}
}
