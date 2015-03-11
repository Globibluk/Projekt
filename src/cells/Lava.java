package cells;


public class Lava extends Cell{
	
	private String spriteName = "lava";
	private int nbSprites = 1;
	private String alternateSpriteName = "lava";
	private int nbAlternateSprites = 1;
	
	public Lava (int x, int y){
		super("Spring", 20, x, y);
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
	}
	public Lava (String season, int temp, int x, int y){		
		super(season, temp, x, y);
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
	}
	
	public String getSpriteName() {
		return spriteName;
	}
	
	public void setSpriteName(String spriteName) {
		this.spriteName = spriteName;
		setSprite(spriteName);
	}
	
	public String getAlternateSpriteName() {
		return alternateSpriteName;
	}
	
	public void setAlternateSpriteName(String spriteName) {
		this.spriteName = spriteName;
		setSprite(spriteName);
	}
}
	