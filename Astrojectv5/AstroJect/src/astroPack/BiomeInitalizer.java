package astroPack;

public class BiomeInitalizer {									// pas du tout opti
	
	private static final double waterProb = 0.0005;
	private static final double waterExpandProb = 0.35;
	private static final double stoneProb = 0.005;
	private static final double stoneExpandProb = 0.35;	
	private static final double sandProb = 0.005;
	private static final double sandExpandProb = 0.35;
	private static final double snowProb = 0.005;
	private static final double snowExpandProb = 0.35;
	private static final double dirtProb = 0.005;
	private static final double dirtExpandProb = 0.35;
	private static final double lavaProb = 0;
	private static final double lavaExpandProb = 0.35;
	private static final int nbCellTypes = 6;	
	
public static void expandWater(int dx, int dy, Cell[][] map) {
		
	int xpos, ypos;
	int nearbyW = 0;
	
		for ( int x = 0 ; x != dx ; x++ ) {
	    	for ( int y = 0 ; y != dy ; y++ ) {
	    		
	    		if ( waterProb > World.randM.nextDouble() && map[x][y] == null)
	    			map[x][y]=new Water(x, y);
	    		
	    		for (int i = x-1; i <= x +1; i++){
	    			for (int j = y -1; j <= y +1; j++){
	    				
	    				xpos = (i+dx) % dx;
	    				ypos = (j + dy) % dy;
	    				
	    				if(map[xpos][ypos] instanceof Water) {
	    					if(World.randM.nextDouble() < waterExpandProb && map[x][y] == null) map[x][y] = new Water(x, y);
	    				}	    		
	    			}
	    		}
	    	}
		}
		
		for ( int x = 0 ; x != dx ; x++ ) {
	    	for ( int y = 0 ; y != dy ; y++ ) {
	    		
	    		nearbyW = 0;
	    		
	    		for (int i = x-1; i <= x +1; i++){
	    			for (int j = y -1; j <= y +1; j++){
	    				
	    				xpos = (i+dx) % dx;
	    				ypos = (j + dy) % dy;
	    				
	    				if(map[xpos][ypos] instanceof Water) nearbyW++;	    				
	    			}
	    		}
	    		
	    		if(nearbyW > 4 && map[x][y] == null) map[x][y] = new Water(x, y);
	    	}
		}
	}

	public static void expandSand(int dx, int dy, Cell[][] map) {
		
		int xpos, ypos;
		int nearbyS = 0;
		
			for ( int x = 0 ; x != dx ; x++ ) {
		    	for ( int y = 0 ; y != dy ; y++ ) {		    		
		    		for (int i = x-1; i <= x +1; i++){
		    			for (int j = y -1; j <= y +1; j++){
		    				
		    				xpos = (i+dx) % dx;
		    				ypos = (j + dy) % dy;
		    				
		    				if((map[xpos][ypos] instanceof Water) && map[x][y] == null) map[x][y] = new Sand(x, y);
		    			}
		    		}
		    	}
			}
			
			for ( int x = 0 ; x != dx ; x++ ) {
		    	for ( int y = 0 ; y != dy ; y++ ) {
		    		
		    		nearbyS = 0;
		    		
		    		for (int i = x-1; i <= x +1; i++){
		    			for (int j = y -1; j <= y +1; j++){
		    				
		    				xpos = (i+dx) % dx;
		    				ypos = (j + dy) % dy;
		    				
		    				if(map[xpos][ypos] instanceof Sand) nearbyS++;	    				
		    			}
		    		}
		    		
		    		if(nearbyS > 3 && map[x][y] == null) map[x][y] = new Sand(x, y);
		    	}
			}
			
		}

	public static void expandStone(int dx, int dy, Cell[][] map) {
	
	int xpos, ypos;
	int nearbyS = 0;
	
		for ( int x = 0 ; x != dx ; x++ ) {
	    	for ( int y = 0 ; y != dy ; y++ ) {
	    		
	    		if (stoneProb > World.randM.nextDouble() && map[x][y] == null)
	    			map[x][y]=new Stone(x, y);
	    		
	    		for (int i = x-1; i <= x +1; i++){
	    			for (int j = y -1; j <= y +1; j++){
	    				
	    				xpos = (i+dx) % dx;
	    				ypos = (j + dy) % dy;
	    				
	    				if(map[xpos][ypos] instanceof Stone && map[x][y] == null) {
	    					if(World.randM.nextDouble() < stoneExpandProb) map[x][y] = new Stone(x, y);
	    				}	    		
	    			}
	    		}
	    	}
		}
		
		for ( int x = 0 ; x != dx ; x++ ) {
	    	for ( int y = 0 ; y != dy ; y++ ) {
	    		
	    		nearbyS = 0;
	    		
	    		for (int i = x-1; i <= x +1; i++){
	    			for (int j = y -1; j <= y +1; j++){
	    				
	    				xpos = (i+dx) % dx;
	    				ypos = (j + dy) % dy;
	    				
	    				if(map[xpos][ypos] instanceof Stone) nearbyS++;	    				
	    			}
	    		}
	    		
	    		if(nearbyS> 4 && map[x][y] == null) map[x][y] = new Stone(x, y);
	    	}
		}
	}
	
	public static void expandSnow(int dx, int dy, Cell[][] map) {
		
		int xpos, ypos;
		int nearbyS = 0;
		
			for ( int x = 0 ; x != dx ; x++ ) {
		    	for ( int y = 0 ; y != dy ; y++ ) {
		    		
		    		if ( snowProb > World.randM.nextDouble() && map[x][y] == null)
		    			map[x][y]=new Snow(x, y);
		    		
		    		for (int i = x-1; i <= x +1; i++){
		    			for (int j = y -1; j <= y +1; j++){
		    				
		    				xpos = (i+dx) % dx;
		    				ypos = (j + dy) % dy;
		    				
		    				if(map[xpos][ypos] instanceof Snow) {
		    					if(World.randM.nextDouble() < snowExpandProb && map[x][y] == null) map[x][y] = new Snow(x, y);
		    				}	    		
		    			}
		    		}
		    	}
			}
			
			for ( int x = 0 ; x != dx ; x++ ) {
		    	for ( int y = 0 ; y != dy ; y++ ) {
		    		
		    		nearbyS = 0;
		    		
		    		for (int i = x-1; i <= x +1; i++){
		    			for (int j = y -1; j <= y +1; j++){
		    				
		    				xpos = (i+dx) % dx;
		    				ypos = (j + dy) % dy;
		    				
		    				if(map[xpos][ypos] instanceof Snow) nearbyS++;	    				
		    			}
		    		}
		    		
		    		if(nearbyS > 4 && map[x][y] == null) map[x][y] = new Snow(x, y);
		    	}
			}
		}

public static void expandDirt(int dx, int dy, Cell[][] map) {
		
		int xpos, ypos;
		int nearbyD = 0;
		
			for ( int x = 0 ; x != dx ; x++ ) {
		    	for ( int y = 0 ; y != dy ; y++ ) {
		    		
		    		if ( dirtProb > World.randM.nextDouble() && map[x][y] == null)
		    			map[x][y]=new Dirt(x, y);
		    		
		    		for (int i = x-1; i <= x +1; i++){
		    			for (int j = y -1; j <= y +1; j++){
		    				
		    				xpos = (i+dx) % dx;
		    				ypos = (j + dy) % dy;
		    				
		    				if(map[xpos][ypos] instanceof Dirt) {
		    					if(World.randM.nextDouble() < dirtExpandProb && map[x][y] == null) map[x][y] = new Dirt(x, y);
		    				}	    		
		    			}
		    		}
		    	}
			}
			
			for ( int x = 0 ; x != dx ; x++ ) {
		    	for ( int y = 0 ; y != dy ; y++ ) {
		    		
		    		nearbyD = 0;
		    		
		    		for (int i = x-1; i <= x +1; i++){
		    			for (int j = y -1; j <= y +1; j++){
		    				
		    				xpos = (i+dx) % dx;
		    				ypos = (j + dy) % dy;
		    				
		    				if(map[xpos][ypos] instanceof Dirt) nearbyD++;	    				
		    			}
		    		}
		    		
		    		if(nearbyD > 4 && map[x][y] == null) map[x][y] = new Dirt(x, y);
		    	}
			}
		}
	

	
}

