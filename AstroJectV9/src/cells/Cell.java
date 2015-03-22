package cells;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public abstract class Cell {
	private int temp;
	private Image sprite;
	private Image alternateSprite;
	private int x;
	private int y;

	public Cell(int temp, int x, int y) {

		this.temp = temp;
		this.x = x;
		this.y = y;
	}

	public Image getSprite() {
		return sprite;
	}

	public Image getAlternateSprite() {
		return alternateSprite;
	}

	public void setSprite(String spriteName) {

		try {
			sprite = ImageIO.read(new File(spriteName));
		} catch (Exception e) {

			System.out.println("Sprite non loaded :" + spriteName);

		}
	}

	public void setAlternateSprite(String alternateSpriteName) {

		try {
			alternateSprite = ImageIO.read(new File(alternateSpriteName));
		} catch (Exception e) {

			System.out.println("Alternate sprite non loaded:" + alternateSpriteName);

		}
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getTemp() {
		return temp;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public abstract String getSpriteName();

	public abstract String getAlternateSpriteName();
	
	public abstract void setSpriteName(String spriteName);
	
	public abstract void setAlternateSpriteName(String alternateSpriteName);

	public void randomizeSprite(int nbSprites) {
		int numSprite = (int) (Math.random() * nbSprites);

		setSprite("sprites/" + getSpriteName() + "_" + numSprite + ".png");
	}

	public void randomizeAlternateSprite(int nbSprites) {
		int numSprite = (int) (Math.random() * nbSprites);

		setAlternateSprite("sprites/" + getAlternateSpriteName() + "_"
				+ numSprite + ".png");
	}

}
