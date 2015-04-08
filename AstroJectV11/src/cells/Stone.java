package cells;

import worldInit.World;

public class Stone extends Cell {

	public Stone(int x, int y) {
		super(20, x, y);
		
		spriteName = "stone";
		nbSprites = 1;
		alternateSpriteName = "reachable";
		nbAlternateSprites = 1;
		
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
		World.getStoneList().add(this);
	}
}