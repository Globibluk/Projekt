package astroPack;

public class Snow extends Cell{
	
	private String spriteName = "sprites/snow";
	private int nbSprites = 1;
	
	public Snow (int x, int y){
		super("Spring", 20, x, y);
		randomizeSprite(nbSprites);
	}
	public Snow (String season, int temp, int x, int y){		
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