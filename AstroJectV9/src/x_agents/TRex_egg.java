package x_agents;

import worldInit.World;

public class TRex_egg extends Egg {

	public TRex_egg(World world, int x, int y, int hatchTime) {
		super(world, x, y, hatchTime);
	}

	public void addNewDino() {
		
		TRex trex = new TRex(world, x, y, 2);
		trex.setSprite("sprites/trexPuffle_0.png");
		world.addCList(trex);
	}

}
