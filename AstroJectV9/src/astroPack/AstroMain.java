package astroPack;

import io.IOSaverLoader;

import java.io.IOException;

import display.SpriteWorld;
import worldInit.World;
import x_agents.Asteroid;
import x_agents.Stegosaurus;
import x_agents.TRex;

public class AstroMain {

	public static void main(String[] args) throws IOException {

		World w = null; // = new World(20, 20);

		try {
			w = IOSaverLoader.Loader(".txt");

		} catch (IOException e) {
			w = new World(50, 50);
			// IOSaverLoader.Saver(w, "100_100.txt");
		}

		for (int i = 0; i < 10; i++)
			new Stegosaurus(w, 1);

		for (int i = 0; i < 6; i++)
			new TRex(w, 2);

		SpriteWorld sw = new SpriteWorld(w);

		int nbExec = 0;
		Asteroid a = null;
			
		while (true) {

			System.out.println(nbExec);
			
			if(nbExec == 500) {
				w.generateAsteroid();
				a = w.getAsteroid();
				w.flood();
			}
			
			if(nbExec == 1500) w.flood();
			
			if(nbExec == 4000) w.unflood();
			
			sw.repaint();
			try {
				Thread.sleep(3); // pause avant le déplacement
			} catch (InterruptedException e) {
			}

			nbExec++;

			if (nbExec % 50 == 0) {


				for (int i = 0; i < w.getCList().size(); i++) {

					w.getCList().get(i).move();

				}
				// w.reproductionCarnivores(w.getCList());

				for (int i = 0; i < w.getHList().size(); i++) {

					w.getHList().get(i).move();

				}

				for (int i = 0; i < w.getEList().size(); i++) {

					w.getEList().get(i).hatch();

				}

				// w.reproductionHerbivores(w.getHList());

				w.regenGrass();

				if(a != null) {
				
					a.move();
					a = w.getAsteroid();
				}

			}

			try {
				Thread.sleep(0); // pause apr�s le d�placement
			} catch (InterruptedException e) {
			}
			System.out.println();

		}

	}

}
