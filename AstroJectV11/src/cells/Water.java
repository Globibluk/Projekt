package cells;

import worldInit.World;

public class Water extends Cell {

	public Water(int x, int y) {
		super(20, x, y);
		
		spriteName = "water";
		nbSprites = 1;
		alternateSpriteName = "water";
		nbAlternateSprites = 1;
		
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
		World.getWaterList().add(this);
	}
}