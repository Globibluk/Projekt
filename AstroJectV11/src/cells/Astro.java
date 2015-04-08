package cells;

public class Astro extends Cell{

	public Astro (int x, int y){
		super(20, x, y);
		
		spriteName = "astro";
		nbSprites = 1;
		alternateSpriteName = "reachable";
		nbAlternateSprites = 1;
		
		randomizeSprite(nbSprites);
		randomizeAlternateSprite(nbAlternateSprites);
	}
}	