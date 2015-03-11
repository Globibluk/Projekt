package astroPack;

public class Dirt extends Cell{
	
	private String spriteName = "sprites/dirt";
	private int nbSprites = 7;	
	
	public Dirt (int x, int y){
		super("Spring", 20, x, y);
		randomizeSprite(nbSprites);
	}
	public Dirt (String season, int temp, int x, int y){		
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
	