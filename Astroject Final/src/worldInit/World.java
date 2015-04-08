package worldInit;

import java.util.ArrayList;
import java.util.Random;

import astroThread.*;
import x_agents.*;
import cells.*;

public class World {
	private static int dx;
	private static int dy;
	public static Random randM;
	
	private AgentsEvents ae;
	private BiomeEvents be;
	private DisplayThread dt;

	private static int xOffSet;
	private static int yOffSet;

	private Cell[][] map;
	private ArrayList<Carnivore> CList;
	private ArrayList<Herbivore> HList;
	private ArrayList<Egg> EList;
	
	private ArrayList<Cell> FloodList;
	private ArrayList<Ice> FreezeList;
	
	private static ArrayList<Dirt> DirtList;
	private static ArrayList<Water> WaterList;
	private static ArrayList<Stone> StoneList;
	
	Asteroid astro;

	public World(int dx, int dy, int randSeed) {
		World.dx = dx;
		World.dy = dy;
		xOffSet = 0;
		yOffSet = 0;
		map = new Cell[dx][dy];
		CList = new ArrayList<Carnivore>();
		HList = new ArrayList<Herbivore>();
		EList = new ArrayList<Egg>();

		FloodList = new ArrayList<Cell>();
		FreezeList = new ArrayList<Ice>();
		
		WaterList = new ArrayList<Water>();
		DirtList = new ArrayList<Dirt>();
		StoneList = new ArrayList<Stone>();
		
		ae = new AgentsEvents(this);
		be = new BiomeEvents(this);
		dt = new DisplayThread(this);

		if(randSeed == 0) randM = new Random();
		else randM = new Random(randSeed);

		populateCells();
	}
	
	public AgentsEvents getAE() {
		return ae;
	}
	
	public BiomeEvents getBE() {
		return be;
	}
	
	public DisplayThread getDT() {
		return dt;
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

	public ArrayList<Egg> getEList() {
		return EList;
	}

	public void addEList(Egg egg) {
		EList.add(egg);
	}

	public static ArrayList<Dirt> getDirtList() {
		return DirtList;
	}

	public static ArrayList<Water> getWaterList() {
		return WaterList;
	}
	
	public static ArrayList<Stone> getStoneList() {
		return StoneList;
	}
	
	public ArrayList<Cell> getFloodList() {
		return FloodList;
	}
	
	public ArrayList<Ice> getFreezeList() {
		return FreezeList;
	}

	public void populateCells() {

		BiomeInitalizer.expandWater(dx, dy, map);
		BiomeInitalizer.expandSand(dx, dy, map);
		BiomeInitalizer.expandStone(dx, dy, map);
		BiomeInitalizer.expandDirt(dx, dy, map);
		BiomeInitalizer.expandTree(dx, dy, map);

		for (int i = 0; i < dx; i++) {
			for (int j = 0; j < dy; j++) {

				if (map[i][j] == null)
					map[i][j] = new Grass(i, j);

			}
		}
	}
	
	public void populateStego() {
		int nb = dx * dy / (InitVar.getAgentProp());
		for (int i = 0; i < nb; i++)
			new Stegosaurus(this, 1);
	}
	
	public void populateTRex() {
		int nb = dx * dy / (InitVar.getAgentProp() * 4);
		for (int i = 0; i < nb; i++)
			new TRex(this, 1);
	}
}