package astroPack;

public class Stone extends Cell{
	
	private String spriteName = "sprites/stone";
	private int nbSprites = 3;
	
	public Stone (int x, int y){
		super("Spring", 20, x, y);
		randomizeSprite(nbSprites);
	}
	public Stone (String season, int temp, int x, int y){		
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