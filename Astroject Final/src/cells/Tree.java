package cells;


public class Tree extends Cell{
	
	public Tree (int x, int y){
		super(20, x, y);
		
		spriteName = "tree";
		nbSprites = 3;
		alternateSpriteName = "reachable";
		nbAlternateSprites = 1;
		
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
	}
}