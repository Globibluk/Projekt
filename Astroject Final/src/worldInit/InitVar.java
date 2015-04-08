package worldInit;

public class InitVar {

	// ////////////////////////////////////////////////
	// ////////////////////////////////////////////////

	// Variables de l'environnement //

	// ////////////////////////////////////////////////

	protected static double waterProb = 0.001;
	protected static double waterExpandProb = 0.35;

	protected static double stoneProb = 0.005;
	protected static double stoneExpandProb = 0.35;

	protected static double sandProb = 0.005;
	protected static double sandExpandProb = 0.35;

	protected static double snowProb = 0.8;
	protected static double snowExpandProb = 0.25;

	public static double getSnowProb() {
		return snowProb;
	}

	protected static double dirtProb = 0.005;
	protected static double dirtExpandProb = 0.35;

	protected static double lavaProb = 0;
	protected static double lavaExpandProb = 0.35;

	protected static double treeProb = 0.05;
	protected static double treeExpandProb = 0.25;

	protected static int nbCellTypes = 6;

	// ////////////////////////////////////////////////
	// ////////////////////////////////////////////////

	// Variables d'affichage //

	// ////////////////////////////////////////////////

	private static String windowName = "Astroject";

	public static String getWindowName() {
		return windowName;
	}

	private static int spriteLength = 16;

	public static int getSpriteLength() {
		return spriteLength;
	}

	private static double agentSpriteSize = 1.6;

	public static double getAgentSpriteSize() {
		return agentSpriteSize;
	}

	public static int moveDiv = 20; // Set movement division for agents

	public static int getmoveDiv() {
		return moveDiv;
	}

	// ////////////////////////////////////////////////
	// ////////////////////////////////////////////////

	// Variables des agents //

	// ////////////////////////////////////////////////

	private static boolean equilibrium = true; // Gestion de l'�quilibrage des
												// esp�ces

	public static boolean getEquilibrium() {
		return equilibrium;
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

	private static int trexEnergyLoss = 250;

	public static int getTRexEnergyLoss() {
		return trexEnergyLoss;
	}

	private static int agentProp = 125;

	public static int getAgentProp() {
		return agentProp;
	}

	private static int totalAgentProp = 25;

	public static int getTotalAgentProp() {
		return totalAgentProp;
	}

	// ////////////////////////////////////////////////
	// ////////////////////////////////////////////////

}
