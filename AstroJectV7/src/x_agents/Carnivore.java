package x_agents;

import worldInit.World;

public abstract class Carnivore extends Dinosaur {

	public Carnivore(World world, int x, int y, int speed) {
		super(world, x, y, speed);
		world.addCList(this);
		
	}
	
	public Carnivore(World world, int speed) {
		super(world, speed);
		world.addCList(this);
	}

	public String toString() {
		return "Carnivore [toString()=" + super.toString() + ", getX()="
				+ getX() + ", getY()=" + getY() + "]";
	}
	
	
	public void eat (Herbivore target){
		
		/* optional, implement poss of eating his own kind */
		
		int tEnergy = target.getEnergy() / 2;
		setEnergy(tEnergy);
		
		target.getWorld().getHList().remove(target);
		dropEgg();
	}
	
	public void killCarnivore(){
		
		if(this.getEnergy() <= 0){
			this.getWorld().getCList().remove(this);
			
		}
			
	}
	
	
	
	

	

	
	
	

}
