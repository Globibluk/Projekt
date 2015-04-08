package x_agents;

import java.util.ArrayList;

import worldInit.InitVar;
import worldInit.World;

public class TRex extends Carnivore {

	private String spriteName = "sprites/pred.png";
	private String eggSpriteName = "sprites/carni_egg.png";

	public TRex(World world, int x, int y, int speed) {
		super(world, x, y, speed);
		setSprite(spriteName);
		energyLoss = InitVar.getTRexEnergyLoss();
	}

	public TRex(World world, int speed) {
		super(world, speed);
		setSprite(spriteName);
		energyLoss = InitVar.getTRexEnergyLoss();
	}

	public String toString() {
		return "TRex [toString()=" + super.toString() + "]";
	}

	public void move() {

		ArrayList<Herbivore> listPreys = getWorld().getHList();
		boolean hasMove = false;

		for (int i = 0; i < listPreys.size(); i++) {

			// take the first herbivore that is close to you and chase him if
			// possible
			Herbivore herbTemp = listPreys.get(i);

			if (distanceTo(intX, intY, herbTemp.getIntX(), herbTemp.getIntY()) < vision) {

				moveStalk(intX, intY, herbTemp.getIntX(), herbTemp.getIntY(),
						speed);
				hasMove = true;

				/* check move order impact on the rate of H survival */

				if (distanceTo(intX, intY, herbTemp.getIntX(),
						herbTemp.getIntY()) == 0) {
					/* if on the same case, eat unlucky the beast */
					eat(herbTemp);
				}

				break;

			}

			moveWander();
			hasMove = true;

		}

		// if no herbviores close than just wonder
		if (!hasMove)
			moveWander();

		int energy = this.getEnergy();
		this.setEnergy(energy - energyLoss);
		//check if he has enough energy to survive
		this.killCarnivore();
		
		//if it was a babydyno, check if he is a grown-up now
		addTimer();
		
		//if he is on a asteroid field, make him a mutant
		onAstro();

	}

	public void dropEgg() {
		if (!alien) {
			//if not an alien, modify current case alternate sprite to egg
			world.getMap()[intX][intY].setAlternateSprite(eggSpriteName);
			world.addEList(new TRex_egg(world, intX, intY, 20));
		}
	}

	public void changeToAlien() {
		if (!alien) {
			//go alien mode xD
			speed++;
			energy = 3000;
			probMove = 0.8;
			setSprite("sprites/pred_alien.png");
			alien = true;
		}
	}

	public String getSpriteName() {
		return spriteName;
	}

}
