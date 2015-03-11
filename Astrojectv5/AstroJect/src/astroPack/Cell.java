package astroPack;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;


public abstract class Cell {
	private String season; /* Spring, Summer, Autumn, Winter */
	private int temp; 
	private Image sprite;
	private Image alternateSprite;
	private int x;
	private int y;
	
	
	public Cell (String season, int temp, int x, int y){
		
		this.season = season;
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
		}
		catch(Exception e) {
			
			//introduire  un sprite par défaut
			
		}		
	}
	
	public void setAlternateSprite(String alternateSpriteName) {
		
		try {
			alternateSprite = ImageIO.read(new File(alternateSpriteName));
		}
		catch(Exception e) {
			
			//introduire  un sprite par défaut
			
		}		
	}
	
	public void changeSeason(String season) {
		this.season = season;
	}
	
	public void changeTemp(int temp) {
		this.temp = temp;
	}
	
	public String getSeason() {
		return season;
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

	public void randomizeSprite(int nbSprites) {
		int numSprite = (int) (Math.random() * nbSprites);
		
		setSprite("sprites/" + getSpriteName() + "_" + numSprite + ".png");		
	}
	
	public void randomizeAlternateSprite(int nbSprites) {
		int numSprite = (int) (Math.random() * nbSprites);
		
		setAlternateSprite(getAlternateSpriteName() + "_" + numSprite + ".png");		
	}
	
}
