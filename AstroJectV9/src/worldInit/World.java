package worldInit;

import java.util.ArrayList;
import java.util.Random;

import x_agents.Asteroid;
import x_agents.Carnivore;
import x_agents.Egg;
import x_agents.Herbivore;
import x_agents.Stegosaurus;
import x_agents.TRex;
import cells.*;

public class World {
	private static int dx;
	private static int dy;
	public static Random randM;

	private static int xOffSet;
	private static int yOffSet;

	private Cell[][] map;
	private ArrayList<Carnivore> CList;
	private ArrayList<Herbivore> HList;
	private ArrayList<Egg> EList;
	private ArrayList<Cell> FloodList;
	
	private static ArrayList<Dirt> DList;
	private static ArrayList<Water> WList;
	
	Asteroid astro;
	
	
	public World(int dx, int dy) {
		World.dx = dx;
		World.dy = dy;
		xOffSet = 0;
		yOffSet = 0;
		map = new Cell[dx][dy];
		
		CList = new ArrayList<Carnivore>();
		HList = new ArrayList<Herbivore>();
		EList = new ArrayList<Egg>();
		WList = new ArrayList<Water>();
		FloodList = new ArrayList<Cell>();
		
		DList = new ArrayList<Dirt>();
		
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
		EList = new ArrayList<Egg>();
		WList = new ArrayList<Water>();
		FloodList = new ArrayList<Cell>();
		
		DList = new ArrayList<Dirt>();
		
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

	public ArrayList<Egg> getEList() {
		return EList;
	}

	public void addEList(Egg egg) {
		EList.add(egg);
	}

	public static ArrayList<Dirt> getDList() {
		return DList;
	}
	
	public static ArrayList<Water> getWList() {
		return WList;
	}	
	
	public void generateAsteroid() {
		int x = (int) (Math.random() * World.dx);
		int y = (int) (Math.random() * World.dy);
		int dX = (int) (Math.random() * World.dx);
		int dY = y + (dX - x);
		astro = new Asteroid(x, y, dX, dY, this);		// randomiser
	}
	
	public Asteroid getAsteroid() {
		return astro;
	}

 	public void populateCells() {

		BiomeInitalizer.expandWater(dx, dy, map);
		BiomeInitalizer.expandSand(dx, dy, map);
		BiomeInitalizer.expandStone(dx, dy, map);
		BiomeInitalizer.expandSnow(dx, dy, map);
		BiomeInitalizer.expandDirt(dx, dy, map);
		BiomeInitalizer.expandTree(dx, dy, map);

		for (int i = 0; i < dx; i++) {
			for (int j = 0; j < dy; j++) {

				if (map[i][j] == null)
					map[i][j] = new Grass(i, j);

			}
		}
	}

	void reproductionCarnivores(ArrayList<Carnivore> CList) {
		int speed;

		int x = World.dx;
		int y = World.dy;
		Carnivore c = null;
		int times = 0;

		int[][] tab = new int[x][y];

		for (int i = 0; i < CList.size(); i++) {

			c = CList.get(i);
			tab[c.getX()][c.getY()]++;

		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (tab[i][j] > 1) {
					times = tab[i][j] / 2;
					speed = c.getSpeed();

					for (int k = 0; k < times; k++) {
						new TRex(this, i, j, speed);

					}

				}
			}
		}

	}

	void reproductionHerbivores(ArrayList<Herbivore> HList) {
		int speed;

		int x = World.dx;
		int y = World.dy;
		Herbivore c = null;
		int times;

		int[][] tab = new int[x][y];

		for (int i = 0; i < HList.size(); i++) {
			c = HList.get(i);
			tab[c.getX()][c.getY()]++;

		}

		for (int i = 0; i < x; i++) {

			for (int j = 0; j < y; j++) {

				if (tab[i][j] > 1) {
					times = tab[i][j] / 2;
					speed = c.getSpeed();

					for (int k = 0; k < times; k++) {

						new Stegosaurus(this, i, j, speed);

					}
				}
			}
		}
	}

	public void regenGrass() {
		for (int i = 0; i < DList.size(); i++) {
			if (Math.random() < 0.01) {
				Dirt dirt = DList.get(i);
				int x = dirt.getX();
				int y = dirt.getY();

				map[x][y] = new Grass(x, y);
				DList.remove(dirt);
			}
		}
	}

	public void impact(int x, int y) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int fx = (dx + i + x) % dx;
				int fy = (dy + j + y) % dy;

				if (!(	   (i == 0 && j == 0) 
						|| (i == 0 && j == 9)
						|| (i == 9 && j == 0) 
						|| (i == 9 && j == 9) 
						|| (i == 1 && j == 0)
						|| (i == 0 && j == 1)
						|| (i == 9 && j == 1)
						|| (i == 1 && j == 9)
						|| (i == 8 && j == 0)
						|| (i == 0 && j == 8)
						|| (i == 9 && j == 8)
						|| (i == 8 && j == 9)
	
	
				)){
					
					if(! (map[fx][fy] instanceof Water)) {
						DList.remove(map[fx][fy]);
						map[fx][fy] = new Astro(fx, fy);
					}
				}
			}
		}
		
		astro = null;
	}
	
	public void flood() {
		
		int xpos, ypos;

		for(int n=0; n<WList.size(); n++) {
			
			int x = WList.get(n).getX();
			int y = WList.get(n).getY();
		
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {

					xpos = (i + dx) % dx;
					ypos = (j + dy) % dy;

					if (!(map[xpos][ypos] instanceof Water)) {
						map[xpos][ypos].setAlternateSpriteName("sprites/water_0.png");
						FloodList.add(map[xpos][ypos]);
					}
				}
			}
		}
	}
	
	public void unflood() {
		
		for(int n=0; n<FloodList.size(); n++) {
			 FloodList.get(n).setAlternateSpriteName("sprites/reachable_0.png");
		}
		FloodList.clear();
	}
		
}