package astroPack;							

public class Grass extends Cell{
	
	private String spriteName = "sprites/grass";
	private int nbSprites = 1;
	
	public Grass (int x, int y){
		super("Spring", 20, x, y);
		randomizeSprite(nbSprites);
	}
	
	public Grass (String season, int temp, int x, int y){		
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
