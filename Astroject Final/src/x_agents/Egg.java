package x_agents;

import worldInit.World;

public abstract class Egg {

	protected World world;
	protected int x;
	protected int y;
	private int age;
	private int hatchTime;

	public Egg(World world, int x, int y, int hatchTime) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.hatchTime = hatchTime;
		age = 0;
	}

	public abstract void addNewDino();

	public void hatch() {
		if (age == hatchTime) {
			world.getEList().remove(this);
			world.getMap()[x][y].setAlternateSprite("sprites/reachable_0.png");
			addNewDino();
		} else
			age++;
	}
}
