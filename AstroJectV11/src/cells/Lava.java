package cells;

public class Lava extends Cell {
	
	public Lava(int x, int y) {
		super(20, x, y);
		
		spriteName = "lava";
		nbSprites = 1;
		alternateSpriteName = "lava";
		nbAlternateSprites = 1;
		
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
	}
}