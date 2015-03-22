package cells;

import worldInit.World;

public class Water extends Cell {

	private String spriteName = "water";
	private int nbSprites = 1;
	private String alternateSpriteName = "water";
	private int nbAlternateSprites = 1;

	public Water(int x, int y) {
		super(20, x, y);
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
		World.getWList().add(this);
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