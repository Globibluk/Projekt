package cells;

public class Grass extends Cell {

	private String spriteName = "grass";
	private int nbSprites = 1;
	private String alternateSpriteName = "reachable";
	private int nbAlternateSprites = 1;

	public Grass(int x, int y) {
		super("Spring", 20, x, y);
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
	}

	public Grass(String season, int temp, int x, int y) {
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
