package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import worldInit.World;
import cells.*;

public class IOSaverLoader {

	public static World Loader(String fileName) throws IOException {

		int dx;
		int dy;

		Scanner scanner = new Scanner(new File(fileName));
		String fileType = scanner.nextLine();

		if (!fileType.equals("#Astro Formated")) {
			System.out.println("Format de sauvegarde incorrect");
			scanner.close();
			return null;
		}

		dx = scanner.nextInt();
		dy = scanner.nextInt();
		World w = new World(dx, dy, 0);

		for (int i = 0; i < dx; i++) {
			for (int j = 0; j < dy; j++) {
				int val = scanner.nextInt(); // monitor the value
				switch (val) {

				case 0:
					w.getMap()[i][j] = new Astro(i, j);
					break;

				case 1:
					w.getMap()[i][j] = new Dirt(i, j);
					break;

				case 2:
					w.getMap()[i][j] = new Grass(i, j);
					break;

				case 3:
					w.getMap()[i][j] = new Ice(i, j);
					break;

				case 4:
					w.getMap()[i][j] = new Lava(i, j);
					break;

				case 5:
					w.getMap()[i][j] = new Sand(i, j);
					break;

				case 6:
					w.getMap()[i][j] = new Snow(i, j);
					break;

				case 7:
					w.getMap()[i][j] = new Stone(i, j);
					break;

				case 8:
					w.getMap()[i][j] = new Water(i, j);
					break;
					
				case 9:
					w.getMap()[i][j] = new Tree(i, j);
					break;
				}
			}
		}

		scanner.close();
		return w;
	}

	public static void Saver(World world, String fileName) throws IOException {

		Writer writer = new FileWriter(fileName);

		int dx = world.getDx();
		int dy = world.getDy();

		writer.write("#Astro Formated\n");
		writer.write(dx + "\n");
		writer.write(dy + "\n");

		for (int i = 0; i < dx; i++) {
			for (int j = 0; j < dy; j++) {

				String caseType = world.getMap()[i][j].getSpriteName();
				switch (caseType) {

				case "astro":
					writer.write("0\n");
					break;

				case "dirt":
					writer.write("1\n");
					break;

				case "grass":
					writer.write("2\n");
					break;

				case "ice":
					writer.write("3\n");
					break;

				case "lava":
					writer.write("4\n");
					break;

				case "sand":
					writer.write("5\n");
					break;

				case "snow":
					writer.write("6\n");
					break;

				case "stone":
					writer.write("7\n");
					break;

				case "water":
					writer.write("8\n");
					break;
					
				case "tree":
					writer.write("9\n");
					break;

				}
			}
		}
		writer.close();

	}
}