package astroPack;

import io.IOSaverLoader;

import java.io.IOException;

import worldInit.World;

public class AstroMain {

	public static void main(String[] args) throws IOException {

		World w = null; // = new World(20, 20);

		try {
			w = IOSaverLoader.Loader(".txt");

		} catch (IOException e) {
			w = new World(35, 35, 1234);
			// IOSaverLoader.Saver(w, "100_100.txt");
		}

		w.populateStego();
		w.populateTRex();

		w.getAE().start();
		w.getBE().start();
		w.getDT().start();
		
	}

}
