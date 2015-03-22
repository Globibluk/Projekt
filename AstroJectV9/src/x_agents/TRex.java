package x_agents;

import java.util.ArrayList;

import worldInit.World;

public class TRex extends Carnivore {

	private String spriteName = "sprites/pred.png";
	private String eggSpriteName = "sprites/carni_egg.png";

	public TRex(World world, int x, int y, int speed) {
		super(world, x, y, speed);
		setSprite(spriteName);
		energyLoss = 75;
	}

	public TRex(World world, int speed) {
		super(world, speed);
		setSprite(spriteName);
		energyLoss = 75;
	}

	public String toString() {
		return "TRex [toString()=" + super.toString() + "]";
	}

	public void move() {

		ArrayList<Herbivore> listPreys = getWorld().getHList();
		boolean hasMove = false;

		for (int i = 0; i < listPreys.size(); i++) {

			Herbivore herbTemp = listPreys.get(i); /*
													 * eventually improve prey
													 * priority
													 */

			if (distanceTo(getX(), getY(), herbTemp.getX(), herbTemp.getY()) < vision) {

				moveStalk(getX(), getY(), herbTemp.getX(), herbTemp.getY(),
						speed);
				hasMove = true;

				/* check move order impact on the rate of H survival */

				if (distanceTo(getX(), getY(), herbTemp.getX(), herbTemp.getY()) == 0) {
					/* if on the same case, eat the bastard */

					eat(herbTemp);
				}

				break;

			}

			moveWander();
			hasMove = true;

		}

		if (!hasMove)
			moveWander();
		int energy = this.getEnergy();
		this.setEnergy(energy - energyLoss);
		this.killCarnivore();
		addTimer();
		onAstro();
		
		

	}

	public void dropEgg() {
		if(!alien) {
			world.getMap()[x][y].setAlternateSprite(eggSpriteName);
			world.addEList(new TRex_egg(world, x, y, 20));
		}
	}

	public void changeToAlien() {
		speed++;
		energy = 3000;
		probMove = 0.8;
		setSprite("sprites/pred_alien.png");
		alien = true;

	}

	public String getSpriteName() {
		return spriteName;
	}

}
