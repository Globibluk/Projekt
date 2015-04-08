package astroThread;

import java.util.ArrayList;

import worldInit.InitVar;
import worldInit.World;
import x_agents.Asteroid;
import cells.*;

public class BiomeEvents extends Thread {

	private World world;

	int dx;
	int dy;

	private Cell map[][];

	private ArrayList<Cell> FloodList;
	private ArrayList<Ice> FreezeList;

	private static ArrayList<Dirt> DirtList;
	private static ArrayList<Water> WaterList;
	private static ArrayList<Stone> StoneList;
	private static ArrayList<Stone> SnowedList;

	private Asteroid astro;

	public BiomeEvents(World world) {

		this.world = world;

		dx = world.getDx();
		dy = world.getDy();

		map = world.getMap();

		FloodList = world.getFloodList();
		FreezeList = world.getFreezeList();

		DirtList = World.getDirtList();
		WaterList = World.getWaterList();

		StoneList = World.getStoneList();
		SnowedList = new ArrayList<Stone>();

	}

	public void run() {

		int nbExec = 1;
		int seasonState = 0;

		while (true) {

			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}

			nbExec++;

			if (nbExec == 500) {
				generateAsteroid();
				astro = getAsteroid();
			}

			if (nbExec % 50 == 0) {

				System.out.println(seasonState);

				seasonState = seasonState % 8;
				seasons(seasonState);
				seasonState++;

			}

			regenGrass();

			if (astro != null) {

				astro.move();
				astro = getAsteroid();
			}

		}

	}

	public void regenGrass() { // changes dirt cells into grass cells

		int rx; // real x (thor)
		int ry; // real x (thor)
		boolean adjGrass = false; // set if there's an adjacent grass

		for (int i = 0; i < DirtList.size(); i++) {

			adjGrass = false;

			for (int ax = -1; ax < 2; ax++) {
				for (int ay = -1; ay < 2; ay++) {
					rx = (ax + dx) % dx;
					ry = (ay + dy) % dy;

					if (map[rx][ry] instanceof Grass)
						adjGrass = true;

				}
			}

			if (adjGrass && Math.random() < 0.01) {
				Dirt dirt = DirtList.get(i);
				int x = dirt.getX();
				int y = dirt.getY();

				map[x][y] = new Grass(x, y);
				DirtList.remove(dirt);

			}
		}
	}

	public void generateAsteroid() { // creates the asteroid
		int x = (int) (Math.random() * dx);
		int y = (int) (Math.random() * dy);
		int dX = (int) (Math.random() * (dx / 10) + dy / 2);
		int dY = y + (dX - x);
		astro = new Asteroid(x, y, dX, dY, world);
	}

	public Asteroid getAsteroid() {
		return astro;
	}

	public void impact(int x, int y) { // displays the asteroid , then overwrite
										// cells, except water ones
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int fx = (dx + i + x) % dx;
				int fy = (dy + j + y) % dy;

				if (!((i == 0 && j == 0) || (i == 0 && j == 9)
						|| (i == 9 && j == 0) || (i == 9 && j == 9)
						|| (i == 1 && j == 0) || (i == 0 && j == 1)
						|| (i == 9 && j == 1) || (i == 1 && j == 9)
						|| (i == 8 && j == 0) || (i == 0 && j == 8)
						|| (i == 9 && j == 8) || (i == 8 && j == 9)

				)) {

					if (!(map[fx][fy] instanceof Water)) {
						DirtList.remove(map[fx][fy]);
						map[fx][fy] = new Astro(fx, fy);
					}
				}
			}
		}

		astro = null;
	}

	public void flood() { // increase water expansion

		int xpos, ypos;

		for (int n = 0; n < WaterList.size(); n++) {

			int x = WaterList.get(n).getX();
			int y = WaterList.get(n).getY();

			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {

					xpos = (i + dx) % dx;
					ypos = (j + dy) % dy;

					if (!(map[xpos][ypos] instanceof Water)) {
						map[xpos][ypos]
								.setAlternateSpriteName("sprites/water_0.png");
						FloodList.add(map[xpos][ypos]);
					}
				}
			}
		}
	}

	public void unflood() { // decrease water expansion

		for (int n = 0; n < FloodList.size(); n++) {
			FloodList.get(n).setAlternateSpriteName("sprites/reachable_0.png");
		}
		FloodList.clear();
	}

	public void freeze() { // changes water cells into ice cells

		for (int n = 0; n < WaterList.size(); n++) {

			int cX = WaterList.get(n).getX();
			int cY = WaterList.get(n).getY();

			Ice iceTemp = new Ice(cX, cY);

			map[cX][cY] = iceTemp;
			FreezeList.add(iceTemp);
		}
		WaterList.clear();
	}

	public void unfreeze() { // changes ice cells into water cells

		for (int n = 0; n < FreezeList.size(); n++) {

			int cX = FreezeList.get(n).getX();
			int cY = FreezeList.get(n).getY();

			Water waterTemp = new Water(cX, cY);

			map[cX][cY] = waterTemp;
			WaterList.add(waterTemp);

		}
		FreezeList.clear();
	}

	public void snow() { // makes snow spawn on stone cells

		for (int n = 0; n < StoneList.size(); n++) {

			if (Math.random() < InitVar.getSnowProb()) {
				StoneList.get(n).setAlternateSprite("sprites/snow_0.png");
				SnowedList.add(StoneList.get(n));
			}
		}
	}

	public void unsnow() { // deletes snow on stone cells

		for (int n = 0; n < SnowedList.size(); n++)
			SnowedList.get(n).setAlternateSprite("sprites/reachable_0.png");

		SnowedList.clear();
	}

	public void seasons(int seasonState) {

		switch (seasonState) {

		case 0:
			flood();
			break;

		case 1:
			unflood();
			break;

		case 2:
			snow();
			break;

		case 3:
			freeze();
			break;

		case 4:
			unfreeze();
			break;

		case 5:
			unsnow();
			break;

		}

	}

}
