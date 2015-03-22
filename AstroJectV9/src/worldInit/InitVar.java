package worldInit;

public class InitVar {

	protected static double waterProb = 0.0005;
	protected static double waterExpandProb = 0.35;

	protected static double stoneProb = 0.005;
	protected static double stoneExpandProb = 0.35;

	protected static double sandProb = 0.005;
	protected static double sandExpandProb = 0.35;

	protected static double snowProb = 0.005;
	protected static double snowExpandProb = 0.35;

	protected static double dirtProb = 0.005;
	protected static double dirtExpandProb = 0.35;

	protected static double lavaProb = 0;
	protected static double lavaExpandProb = 0.35;
	
	protected static double treeProb = 0.005;
	protected static double treeExpandProb = 0.35;


	protected static int nbCellTypes = 6;
	
	private static int spriteLength = 16;
	
	public static int getSpriteLength() {
		return spriteLength;
	}
	
	private static int vision = 5;
	
	public static int getVision() {
		return vision;
	}
	
	private static double probMove = 0.4;
	
	public static double getProbMove() {
		return probMove;
	}
	
	private static int energy = 4000;
	
	public static int getEnergy() {
		return energy;
	}

	private static int stegoEnergyLoss = 250;
	
	public static int getStegoEnergyLoss() {
		return stegoEnergyLoss;
	}

}
