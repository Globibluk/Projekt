package cells;

import worldInit.World;

public class Dirt extends Cell {

	private String spriteName = "dirt";
	private int nbSprites = 7;
	private String alternateSpriteName = "reachable";
	private int nbAlternateSprites = 1;

	public Dirt(int x, int y) {
		super(20, x, y);
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
		World.getDList().add(this);
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