package astroThread;

import java.util.ArrayList;

import cells.Cell;
import worldInit.InitVar;
import worldInit.World;
import x_agents.*;

public class AgentsEvents extends Thread {

	private World world;
	private Cell[][] map;
	private ArrayList<Carnivore> CList;
	private ArrayList<Herbivore> HList;
	private ArrayList<Egg> EList;

	int dx;
	int dy;

	public AgentsEvents(World world) {

		this.world = world;
		map = world.getMap();
		CList = world.getCList();
		HList = world.getHList();
		EList = world.getEList();

		dx = world.getDx();
		dy = world.getDy();

	}

	public void run() {
		//main loop
		while (true) {

			try {
				Thread.sleep(20);
			} catch (Exception e) {
			}

			moveAgents();

			if (InitVar.getEquilibrium())
				equilibrium();

			errorChecker();

		}
	}

	public void equilibrium() {
		
		// make sure that there is an equilibrium between the agent number

		int sizeCarnivore = CList.size();
		int sizeHerbivore = HList.size();
		int agentProp = InitVar.getAgentProp();
		int totalAgentProp = InitVar.getTotalAgentProp();

		if (sizeHerbivore + sizeCarnivore <= dx * dy / totalAgentProp) {
			// more Carnivores
			if (sizeHerbivore == 0 || sizeHerbivore < dx * dy / agentProp
					|| sizeCarnivore / sizeHerbivore > 1) {
				HList.add(new Stegosaurus(world, 1));
			}

			if (sizeCarnivore == 0 || sizeCarnivore < dx * dy / agentProp
					|| sizeHerbivore / sizeCarnivore > 3) {
				CList.add(new TRex(world, 1));
			}
		}

		else {

			while (sizeHerbivore + sizeCarnivore > dx * dy / totalAgentProp) {

				boolean opDone = false;

				sizeCarnivore = CList.size();
				sizeHerbivore = HList.size();

				// kill older
				if (sizeHerbivore == 0 || sizeCarnivore / sizeHerbivore > 1) {
					CList.remove(0);
					opDone = true;
				}

				if (sizeCarnivore == 0 || sizeHerbivore / sizeCarnivore > 3) {
					HList.remove(0);
					opDone = true;
				}

				if (!opDone) {
					//if neither happened
					CList.remove(0);
					HList.remove(0);
				}
			}
		}

	}

	public void errorChecker() {

		int x;
		int y;
		
		//if we were on ice and it melted
		//or on sand and it got flood
		//remove the agent

		if (CList != null) {

			for (int i = 0; i < CList.size(); i++) {
				x = CList.get(i).getIntX();
				y = CList.get(i).getIntY();

				if (!(map[x][y].getAlternateSpriteName().equals("reachable"))) {
					CList.remove(i);
				}
			}
		}

		if (HList != null) {

			for (int i = 0; i < HList.size(); i++) {
				x = HList.get(i).getIntX();
				y = HList.get(i).getIntY();

				if (!(map[x][y].getAlternateSpriteName().equals("reachable"))) {
					HList.remove(i);
				}
			}
		}
	}

	public void moveAgents() {
		
		//gliding movement of the agents

		for (int i = 0; i < CList.size(); i++) {

			Carnivore carnTemp = CList.get(i);
			//where we are
			double x = carnTemp.getX();
			double y = carnTemp.getY();
			
			//where we want to go
			int intX = carnTemp.getIntX();
			int intY = carnTemp.getIntY();

			if (!carnTemp.isMoving()) {

				carnTemp.move();
				carnTemp.setMoving(true);
				
				intX = carnTemp.getIntX();
				intY = carnTemp.getIntY();

				double shortestXDiff;
				double shortestYDiff;
				
				//movement direction for x
				if (Math.abs(intX - x) < world.getDx()/2)
					shortestXDiff = (int) (intX - x);

				else {
					if (intX - x > 0) shortestXDiff = - (int) (world.getDx() - (intX - x));
					else shortestXDiff = (int) (world.getDx() - Math.abs(intX - x));
				}
				
				
				//movement direction for y
				if (Math.abs(intY - y) < world.getDy()/2)
					shortestYDiff = (int) (intY - y);

				else {
					//incremention position in x and y
					if (intY - y > 0) shortestYDiff = - (int) (world.getDy() - (intY - y));
					else shortestYDiff = (int) (world.getDy() - Math.abs(intY - y));
				}
				
				carnTemp.setXMoveDir(shortestXDiff / InitVar.getmoveDiv());
				carnTemp.setYMoveDir(shortestYDiff / InitVar.getmoveDiv());
				
			}
				//moving the sprite
			
			if (carnTemp.getMoveCount() != InitVar.getmoveDiv()) {
				//while animation frame not ended
				carnTemp.setMoveCount(carnTemp.getMoveCount() + 1);
				if((int) x != intX)	carnTemp.setX((carnTemp.getX() + carnTemp.getXMoveDir() + world.getDx()) % world.getDx());
				if((int) y != intY) carnTemp.setY((carnTemp.getY() + carnTemp.getYMoveDir() + world.getDy()) % world.getDy());
			}
			
			else {
				//if animation frame ended, prepare for next movement
				carnTemp.setMoveCount(0);
				carnTemp.setMoving(false);
				carnTemp.setXMoveDir(0);
				carnTemp.setYMoveDir(0);
			}
		}

		for (int i = 0; i < HList.size(); i++) {

			Herbivore herbTemp = HList.get(i);
			double x = herbTemp.getX();
			double y = herbTemp.getY();
			int intX = herbTemp.getIntX();
			int intY = herbTemp.getIntY();

			if (!herbTemp.isMoving()) {

				herbTemp.move();
				herbTemp.setMoving(true);
				
				intX = herbTemp.getIntX();
				intY = herbTemp.getIntY();

				double shortestXDiff;
				double shortestYDiff;
				
				
				
				if (Math.abs(intX - x) < world.getDx()/2)
					shortestXDiff = (int) (intX - x);

				else {
					if (intX - x > 0) shortestXDiff = - (int) (world.getDx() - (intX - x));
					else shortestXDiff = (int) (world.getDx() - Math.abs(intX - x));
				}

				if (Math.abs(intY - y) < world.getDy()/2)
					shortestYDiff = (int) (intY - y);

				else {
					if (intY - y > 0) shortestYDiff = - (int) (world.getDy() - (intY - y));
					else shortestYDiff = (int) (world.getDy() - Math.abs(intY - y));
				}
				
				herbTemp.setXMoveDir(shortestXDiff / InitVar.getmoveDiv());
				herbTemp.setYMoveDir(shortestYDiff / InitVar.getmoveDiv());
			
			}
			
			if (herbTemp.getMoveCount() != InitVar.getmoveDiv()) {
				herbTemp.setMoveCount(herbTemp.getMoveCount() + 1);
				if((int) x != intX)	herbTemp.setX((herbTemp.getX() + herbTemp.getXMoveDir() + world.getDx()) % world.getDx());
				if((int) y != intY) herbTemp.setY((herbTemp.getY() + herbTemp.getYMoveDir() + world.getDy()) % world.getDy());
			}
			
			else {
				herbTemp.setMoveCount(0);
				herbTemp.setMoving(false);
				herbTemp.setXMoveDir(0);
				herbTemp.setYMoveDir(0);
			}
		}

		for (int i = 0; i < EList.size(); i++) {
			EList.get(i).hatch();
		}
	}

}
