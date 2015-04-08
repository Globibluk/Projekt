package cells;

import worldInit.World;

public class Dirt extends Cell {

	public Dirt(int x, int y) {
		super(20, x, y);
		
		spriteName = "dirt";
		nbSprites = 7;
		alternateSpriteName = "reachable";
		nbAlternateSprites = 1;
		
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
		World.getDirtList().add(this);
	}
}