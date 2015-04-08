package astroThread;

import worldInit.World;
import display.SpriteWorld;

public class DisplayThread extends Thread{

	private World world;
	private SpriteWorld sw;
	
	public DisplayThread(World world) {
		
		this.world = world;
		
		sw = new SpriteWorld(this.world);
	}
	
	public void run() {
		
		while(true) {
		
			sw.repaint();
			
		}
		
	}	
}
