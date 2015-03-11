package astroPack;

import io.IOSaverLoader;

import java.io.IOException;

import display.SpriteWorld;
import worldInit.World;
import x_agents.Stegosaurus;
import x_agents.TRex;

public class AstroMain {

	public static void main(String[] args) {

		World w; // = new World(20, 20);

		try {
			w = IOSaverLoader.Loader("saves.txt");
		} catch (IOException e) {
			w = new World(20, 20, 10);
		}

		Stegosaurus s1 = new Stegosaurus(w, 1);
		TRex t1 = new TRex(w, 2);
		TRex t2 = new TRex(w, 2);
		//TRex t3 = new TRex(w, 2);
		//TRex t4 = new TRex(w, 2);

		Stegosaurus s2 = new Stegosaurus(w, 1);
		Stegosaurus s3 = new Stegosaurus(w, 1);
		Stegosaurus s4 = new Stegosaurus(w, 1);

		SpriteWorld sw = new SpriteWorld(w);

		int nbExec = 0;

		while (true) {

			sw.repaint();
			try {
				Thread.sleep(10); // pause avant le déplacement
			} catch (InterruptedException e) {
			}

			nbExec++;

			if (nbExec >= 30) {

				nbExec = 0;

				for (int i = 0; i < w.getCList().size(); i++) {

					w.getCList().get(i).move();

				}
				//w.reproductionCarnivores(w.getCList());

				for (int i = 0; i < w.getHList().size(); i++) {

					w.getHList().get(i).move();

				}
				
				for (int i = 0; i < w.getEList().size(); i++) {

					w.getEList().get(i).hatch();

				}

				//w.reproductionHerbivores(w.getHList());
			}

			try {
				Thread.sleep(0); // pause après le déplacement
			} catch (InterruptedException e) {
			}
			System.out.println();

		}

	}

}
