package worldInit;

import cells.Cell;
import cells.Dirt;
import cells.Sand;
import cells.Snow;
import cells.Stone;
import cells.Tree;
import cells.Water;

public class BiomeInitalizer { // pas du tout du tout opti

	public static void expandWater(int dx, int dy, Cell[][] map) {

		int xpos, ypos;
		int nearbyW = 0;

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				if (InitVar.waterProb > World.randM.nextDouble()
						&& map[x][y] == null)
					map[x][y] = new Water(x, y);

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Water) {
							if (World.randM.nextDouble() < InitVar.waterExpandProb
									&& map[x][y] == null)
								map[x][y] = new Water(x, y);
						}
					}
				}
			}
		}

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				nearbyW = 0;

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Water)
							nearbyW++;
					}
				}

				if (nearbyW > 4 && map[x][y] == null)
					map[x][y] = new Water(x, y);
			}
		}
	}

	public static void expandSand(int dx, int dy, Cell[][] map) {

		int xpos, ypos;
		int nearbyS = 0;

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {
				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if ((map[xpos][ypos] instanceof Water)
								&& map[x][y] == null)
							map[x][y] = new Sand(x, y);
					}
				}
			}
		}

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				nearbyS = 0;

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Sand)
							nearbyS++;
					}
				}

				if (nearbyS > 3 && map[x][y] == null)
					map[x][y] = new Sand(x, y);
			}
		}

	}

	public static void expandStone(int dx, int dy, Cell[][] map) {

		int xpos, ypos;
		int nearbyS = 0;

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				if (InitVar.stoneProb > World.randM.nextDouble()
						&& map[x][y] == null)
					map[x][y] = new Stone(x, y);

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Stone
								&& map[x][y] == null) {
							if (World.randM.nextDouble() < InitVar.stoneExpandProb)
								map[x][y] = new Stone(x, y);
						}
					}
				}
			}
		}

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				nearbyS = 0;

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Stone)
							nearbyS++;
					}
				}

				if (nearbyS > 4 && map[x][y] == null)
					map[x][y] = new Stone(x, y);
			}
		}
	}

	public static void expandSnow(int dx, int dy, Cell[][] map) {

		int xpos, ypos;
		int nearbyS = 0;

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				if (InitVar.snowProb > World.randM.nextDouble()
						&& map[x][y] == null)
					map[x][y] = new Snow(x, y);

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Snow) {
							if (World.randM.nextDouble() < InitVar.snowExpandProb
									&& map[x][y] == null)
								map[x][y] = new Snow(x, y);
						}
					}
				}
			}
		}

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				nearbyS = 0;

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Snow)
							nearbyS++;
					}
				}

				if (nearbyS > 4 && map[x][y] == null)
					map[x][y] = new Snow(x, y);
			}
		}
	}

	public static void expandDirt(int dx, int dy, Cell[][] map) {

		int xpos, ypos;
		int nearbyD = 0;

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				if (InitVar.dirtProb > World.randM.nextDouble()
						&& map[x][y] == null)
					map[x][y] = new Dirt(x, y);

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Dirt) {
							if (World.randM.nextDouble() < InitVar.dirtExpandProb
									&& map[x][y] == null)
								map[x][y] = new Dirt(x, y);
						}
					}
				}
			}
		}

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				nearbyD = 0;

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Dirt)
							nearbyD++;
					}
				}

				if (nearbyD > 4 && map[x][y] == null)
					map[x][y] = new Dirt(x, y);
			}
		}
	}
	
	public static void expandTree(int dx, int dy, Cell[][] map) {

		int xpos, ypos;
		int nearbyT = 0;

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				if (InitVar.treeProb > World.randM.nextDouble()
						&& map[x][y] == null)
					map[x][y] = new Tree(x, y);

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Tree) {
							if (World.randM.nextDouble() < InitVar.treeExpandProb
									&& map[x][y] == null)
								map[x][y] = new Tree(x, y);
						}
					}
				}
			}
		}

		for (int x = 0; x != dx; x++) {
			for (int y = 0; y != dy; y++) {

				nearbyT = 0;

				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {

						xpos = (i + dx) % dx;
						ypos = (j + dy) % dy;

						if (map[xpos][ypos] instanceof Tree)
							nearbyT++;
					}
				}

				if (nearbyT > 4 && map[x][y] == null)
					map[x][y] = new Tree(x, y);
			}
		}
	}

}
