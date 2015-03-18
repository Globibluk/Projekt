package x_agents;

import worldInit.World;

public class TRex_egg extends Egg{
	
	public TRex_egg(World world, int x, int y, int hatchTime) {
		super(world, x, y, hatchTime);
	}

	public void addNewDino() {
		world.addCList(new TRex(world, x, y, 2));		
	}

}
