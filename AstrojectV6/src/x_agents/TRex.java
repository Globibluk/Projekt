package x_agents;

import java.util.ArrayList;

import worldInit.World;

public class TRex extends Carnivore {

	private final int speedCap =  1;
	private final int vision = 5;
	private final int energyLoss = 50;
	
	private String spriteName = "sprites/pred.png";
	private String eggSpriteName = "sprites/carni_egg.png";

	
	public TRex(World world, int x, int y, int speed) {
		super(world, x, y, speed);
		setSprite(spriteName);
	}
	
	public TRex(World world, int speed) {
		super(world, speed);
		setSprite(spriteName);
	}

	public String toString() {
		return "TRex [toString()=" + super.toString() + "]";
	}

	public void move() {
		
		ArrayList <Herbivore> listPreys = getWorld().getHList();
		boolean hasMove = false;
		
		for(int i = 0; i < listPreys.size(); i++) {
			
			Herbivore herbTemp = listPreys.get(i);		/* eventually improve prey priority */
			
				if(distanceTo(getX(), getY(), herbTemp.getX(), herbTemp.getY()) < vision) {
					
					moveStalk(getX(), getY(), herbTemp.getX(), herbTemp.getY(), speedCap);
					hasMove = true;
					
					/*check move order impact on the rate of H survival */
					
					if (distanceTo(getX(), getY(), herbTemp.getX(), herbTemp.getY()) == 0){
						/*if on the same case, eat the bastard */
						
						eat(herbTemp);
					}
									
					break;
					
				}
		
				moveWander();
				hasMove = true;
				
		}
		
		if(!hasMove) moveWander();	
		int energy = this.getEnergy();
		this.setEnergy(energy-energyLoss);
		this.killCarnivore();
					
	}
	
	public void dropEgg() {
			world.getMap()[x][y].setAlternateSprite(eggSpriteName);
			world.addEList(new TRex_egg(world, x, y, 10));
	}
}
