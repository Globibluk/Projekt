package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import worldInit.World;
import cells.Grass;
import cells.Sand;
import cells.Water;

public class IOSaverLoader {
	
	public static World Loader(String fileName) throws IOException {
		
			int dx;
			int dy;
			
			Scanner scanner = new Scanner(new File(fileName));
			String fileType = scanner.nextLine();
			
			if(!fileType.equals("#Astro Formated")) {
				System.out.println("Format de sauvegarde incorrect");
				scanner.close();
				return null;
			}
			
			dx =scanner.nextInt();
			System.out.println(dx);
			dy =scanner.nextInt();
			System.out.println(dy);
			World w = new World(dx, dy);
			
			// a compléter redémarrage avec biome uniquement
			
			for( int i = 0; i < dx; i++) {
				for( int j = 0; j < dy; j++) {
					int val = scanner.nextInt();				//monitor the value
					switch(val) {
					
						case 0 :
							w.getMap()[i][j] = new Grass(i, j);
							break;
							
						case 1 :
							w.getMap()[i][j] = new Water(i, j);
							break;
							
						case 2 :
							w.getMap()[i][j] = new Sand(i, j);
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
		
		for( int i = 0; i < dx; i++) {
			for( int j = 0; j < dy; j++) {
		
				String caseType = world.getMap()[i][j].getSpriteName();
				switch (caseType) {
				
					case "grass.png" :
						writer.write("0\n");
						break;
						
					case "water.png" :
						writer.write("1\n");
						break;
						
					case "sand.png" :
						writer.write("2\n");
						break;
				
				}
			}
		}
		writer.close();
		
	}
}