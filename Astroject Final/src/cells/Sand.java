package cells;

public class Sand extends Cell {

	public Sand(int x, int y) {
		super(20, x, y);
		
		spriteName = "sand";
		nbSprites = 1;
		alternateSpriteName = "reachable";
		nbAlternateSprites = 1;
		
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
	}
}