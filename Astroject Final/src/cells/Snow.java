package cells;

public class Snow extends Cell {

	public Snow(int x, int y) {
		super(20, x, y);
		
		spriteName = "snow";
		nbSprites = 1;
		alternateSpriteName = "reachable";
		nbAlternateSprites = 1;
		
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
	}
}