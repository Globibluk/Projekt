package astroPack;

import astroPack.Cell;

public class Lava extends Cell{
	
	private String spriteName = "sprites/lava";
	private int nbSprites = 1;
	
	public Lava (int x, int y){
		super("Spring", 20, x, y);
		randomizeSprite(nbSprites);
	}
	public Lava (String season, int temp, int x, int y){		
		super(season, temp, x, y);
		randomizeSprite(nbSprites);
	}
	
	public String getSpriteName() {
		return spriteName;
	}
	
	public void setSpriteName(String spriteName) {
		this.spriteName = spriteName;
		setSprite(spriteName);
	}
}
	