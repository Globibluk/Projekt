package astroPack;

public class Sand extends Cell{
	
	private String spriteName = "sprites/sand";
	private int nbSprites = 1;
	
	public Sand (int x, int y){
		super("Spring", 20, x, y);
		randomizeSprite(nbSprites);
	}
	public Sand (String season, int temp, int x, int y){		
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
