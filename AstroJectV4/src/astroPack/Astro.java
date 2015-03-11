package astroPack;

import astroPack.Cell;

public class Astro extends Cell{
	
	private String spriteName = "astro.png";
	
	public Astro (int x, int y){
		super("Spring", 20, x, y);
		setSprite(spriteName);
	}
	public Astro (String season, int temp, int x, int y){		
		super(season, temp, x, y);
		setSprite(spriteName);
	}
	
	public String getSpriteName() {
		return spriteName;
	}
	
	public void setSpriteName(String spriteName) {
		this.spriteName = spriteName;
		setSprite(spriteName);
	}
}
	