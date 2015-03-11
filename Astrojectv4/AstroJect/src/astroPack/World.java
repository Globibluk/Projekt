package astroPack;

import java.util.ArrayList;
import java.util.Random;

public class World {
	private static int dx;							// peut etre à régler
	private static int dy;
	protected static Random randM;
	
	private static int xOffSet;
	private static int yOffSet;
	

	private Cell[][] map;
	private ArrayList<Carnivore> CList;
	private ArrayList<Herbivore> HList;
	private ArrayList<Water> WList;

	public World(int dx, int dy) {
		World.dx = dx;
		World.dy = dy;
		xOffSet = 0;
		yOffSet = 0;
		map = new Cell[dx][dy];
		CList = new ArrayList<Carnivore>();
		HList = new ArrayList<Herbivore>();
		WList = new ArrayList<Water>();						//revoir la liste des cases eau
		randM = new Random();

		populateCells();

	}
	
	public World(int dx, int dy, int randSeed) {
		World.dx = dx;
		World.dy = dy;
		xOffSet = 0;
		yOffSet = 0;
		map = new Cell[dx][dy];
		CList = new ArrayList<Carnivore>();
		HList = new ArrayList<Herbivore>();
		randM = new Random(randSeed);

		populateCells();

	}

	public Cell[][] getMap() {
		return map;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}
	
	public int getxOffSet() {
		return xOffSet;
	}

	public static void addXOffSet(int x) {
		xOffSet = (xOffSet + x + dx) % dx; 
	}

	public int getyOffSet() {
		return yOffSet;
	}

	public static void addYOffSet(int y) {
		yOffSet = (yOffSet + y + dy) % dy;
	}
	
	public ArrayList<Carnivore> getCList() {
		return CList;
	}

	public void addCList(Carnivore carnivore) {
		CList.add(carnivore);
	}

	public ArrayList<Herbivore> getHList() {
		return HList;
	}

	public void addHList(Herbivore herbivore) {
		HList.add(herbivore);
	}

	public ArrayList<Water> getWlist() {
		return WList;
	}

	public void addWList(Water water) {
		WList.add(water);
	}
	
	

	public void populateCells() {

		BiomeInitalizer.expandWater(dx, dy, map);
		BiomeInitalizer.expandSand(dx, dy, map);
		BiomeInitalizer.expandStone(dx, dy, map);
		BiomeInitalizer.expandSnow(dx, dy, map);
		BiomeInitalizer.expandDirt(dx, dy, map);
		
		for (int i = 0; i < dx; i++) {
			for (int j = 0; j < dy; j++) {
				
				if(map[i][j] == null) map[i][j] = new Grass(i, j);
				
			}
		}		
	}
}
