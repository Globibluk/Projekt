package x_agents;

import worldInit.World;

public class Stego_egg extends Egg {

	public Stego_egg(World world, int x, int y, int hatchTime) {
		super(world, x, y, hatchTime);
	}

	public void addNewDino() {
		world.addHList(new Stegosaurus(world, x, y, 1));
	}

}
