package astroPack;

public abstract class Herbivore extends Dinosaur{

	public Herbivore(World world, int x, int y, int speed) {
		super(world, x, y, speed);
		world.addHList(this);
		
	}

	public Herbivore(World world, int speed) {
		super(world, speed);
		world.addHList(this);
		
	}

	
	public String toString() {
		return "Herbivore []";
	}
	
	
	public void killHerbivore(){
		
		if(this.getEnergy() <= 0){
			this.getWorld().getHList().remove(this);
			
		}
			
	}
	
	
	
	
	
	
	

}
