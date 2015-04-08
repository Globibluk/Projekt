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

	public SpriteWorld(World world) {
		sprites = world.getMap();
		this.world = world;
		frame = new JFrame(InitVar.getWindowName());
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
		int agentSpriteSize = (int) (spriteLength * InitVar.getAgentSpriteSize());
		int xCell;
		int yCell;
		Image sprite;
		Image alternateSprite;

		for (int i = 0; i < sprites.length; i++)
			for (int j = 0; j < sprites[0].length; j++) {

				xCell = (i + xOff + dx) % dx;
				yCell = (j + yOff + dy) % dy;
				
				sprite = null;
				alternateSprite = null;

				if (sprites[xCell][yCell] != null) {

					sprite = sprites[xCell][yCell].getSprite();
					alternateSprite = sprites[xCell][yCell].getAlternateSprite();
				}

				g2.drawImage(sprite, spriteLength * i, spriteLength * j,
						spriteLength, spriteLength, frame);
				g2.drawImage(alternateSprite, spriteLength * i, spriteLength
						* j, spriteLength, spriteLength, frame);
			}

		for (int i = 0; i < world.getHList().size(); i++) {
			int x = world.getHList().get(i).getIntX();
			int y = world.getHList().get(i).getIntY();
			
			int decalX = (int) ((world.getHList().get(i).getX() - x) * spriteLength);		// décallage X pour déplacement fluide
			int decalY = (int) ((world.getHList().get(i).getY() - y) * spriteLength);		// décallage Y pour déplacement fluide
			
			x = (x - xOff + dx) % dx;
			y = (y - yOff + dy) % dy;

			g2.drawImage(world.getHList().get(i).getSprite(), (spriteLength * x)
					- (spriteLength / 2) + decalX, (spriteLength * y) - (spriteLength / 2) + decalY,
					agentSpriteSize, agentSpriteSize, frame);

		}

		for (int i = 0; i < world.getCList().size(); i++) {
			int x = world.getCList().get(i).getIntX();
			int y = world.getCList().get(i).getIntY();
			
			int decalX = (int) ((world.getCList().get(i).getX() - x) * spriteLength);		// décallage X pour déplacement fluide
			int decalY = (int) ((world.getCList().get(i).getY() - y) * spriteLength);		// décallage Y pour déplacement fluide
			
			x = (x - xOff + dx) % dx;
			y = (y - yOff + dy) % dy;

			g2.drawImage(world.getCList().get(i).getSprite(), (spriteLength * x)
					- (spriteLength / 2) + decalX, (spriteLength * y) - (spriteLength / 2) + decalY,
					agentSpriteSize, agentSpriteSize, frame);

		}

		if (world.getBE().getAsteroid() != null) {
			Asteroid sTemp = world.getBE().getAsteroid();
			int aX = sTemp.getX();
			int aY = sTemp.getY();
			int astroSpriteReduc = 8 * (aX - sTemp.getXDest());
			if (astroSpriteReduc < 0)
				astroSpriteReduc = -astroSpriteReduc;

			int finalSpriteSize = sTemp.getSpriteSize() - astroSpriteReduc;
			if (finalSpriteSize < 0)
				finalSpriteSize = 0;

			int posX = spriteLength * aX - spriteLength / 2
					- (xOff * spriteLength);
			int posY = spriteLength * aY - spriteLength / 2
					- (yOff * spriteLength);

			g2.drawImage(sTemp.getSprite(), posX, posY, finalSpriteSize,
					finalSpriteSize, frame);
		}

	}
}
