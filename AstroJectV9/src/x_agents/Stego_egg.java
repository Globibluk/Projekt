package x_agents;

import worldInit.World;

public class Stego_egg extends Egg {

	public Stego_egg(World world, int x, int y, int hatchTime) {
		super(world, x, y, hatchTime);
	}

	public void addNewDino() {
		Stegosaurus steg = new Stegosaurus(world, x, y, 1);
		steg.setSprite("sprites/stegoPuffle_0.png");
		world.addHList(steg);
	}

}
