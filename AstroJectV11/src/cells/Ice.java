package cells;

public class Ice extends Cell {

	public Ice(int x, int y) {
		super(20, x, y);
		
		spriteName = "ice";
		nbSprites = 1;
		alternateSpriteName = "reachable";
		nbAlternateSprites = 1;
		
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
	}
}