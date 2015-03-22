package display;

import io.KeyEventDispatcherAstro;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import worldInit.InitVar;
import worldInit.World;
import x_agents.Asteroid;
import cells.Cell;

public class SpriteWorld extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	private static int spriteLength = InitVar.getSpriteLength();

	private Cell[][] sprites;
	private World world;

	private Graphics2D g2;

	public SpriteWorld(World world) {
		sprites = world.getMap();
		this.world = world;
		frame = new JFrame("Astroject");
		frame.add(this);
		frame.setSize(world.getDx() * spriteLength, world.getDy()
				* spriteLength);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		KeyboardFocusManager manager = KeyboardFocusManager
				.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new KeyEventDispatcherAstro());

		frame.setVisible(true);
		setFocusable(true);

	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	public static void setSpriteLength(int length) {
		SpriteWorld.spriteLength = length;
	}

	public static int getSpriteLength() {
		return SpriteWorld.spriteLength;
	}

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		int xOff = world.getxOffSet();
		int yOff = world.getyOffSet();
		int dx = world.getDx();
		int dy = world.getDy();
		int agentSpriteSize = spriteLength * 3 / 2;

		for (int i = 0; i < sprites.length; i++)
			for (int j = 0; j < sprites[0].length; j++) {
				g2.drawImage(
						sprites[(i + xOff + dx) % dx][(j + yOff + dy) % dy]
								.getSprite(), spriteLength * i, spriteLength
								* j, spriteLength, spriteLength, frame);
				g2.drawImage(
						sprites[(i + xOff + dx) % dx][(j + yOff + dy) % dy]
								.getAlternateSprite(), spriteLength * i,
						spriteLength * j, spriteLength, spriteLength, frame);

			}

		for (int i = 0; i < world.getHList().size(); i++) {
			int x = world.getHList().get(i).getX();
			int y = world.getHList().get(i).getY();
			x = (x - xOff + dx) % dx;
			y = (y - yOff + dy) % dy;

			g2.drawImage(world.getHList().get(i).getSprite(), spriteLength * x
					- spriteLength / 2, spriteLength * y - spriteLength / 2,
					agentSpriteSize, agentSpriteSize, frame);

		}

		for (int i = 0; i < world.getCList().size(); i++) {
			int x = world.getCList().get(i).getX();
			int y = world.getCList().get(i).getY();
			x = (x - xOff + dx) % dx;
			y = (y - yOff + dy) % dy;

			g2.drawImage(world.getCList().get(i).getSprite(), spriteLength * x
					- spriteLength / 2, spriteLength * y - spriteLength / 2,
					agentSpriteSize, agentSpriteSize, frame);

		}

		if (world.getAsteroid() != null) {
			Asteroid sTemp = world.getAsteroid();
			int aX = sTemp.getX();
			int aY = sTemp.getY();
			int dX = 0;
			int dY = 0;

			int posX = spriteLength * aX - spriteLength / 2
					- (xOff * spriteLength);
			int posY = spriteLength * aY - spriteLength / 2
					- (yOff * spriteLength);

			g2.drawImage(sTemp.getSprite(), posX, posY, sTemp.getSpriteSize() - dX, sTemp.getSpriteSize() - dY, frame);
		}

	}
}
