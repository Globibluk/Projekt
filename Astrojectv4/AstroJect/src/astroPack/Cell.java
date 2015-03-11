package astroPack;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;


public abstract class Cell {
	private String season; /* Spring, Summer, Autumn, Winter */
	private int temp; 
	private Image sprite;
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
	
	public void setSprite(String spriteName) {
		
		try {
			sprite = ImageIO.read(new File(spriteName));
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

	public void randomizeSprite(int nbSprites) {
		int numSprite = (int) (Math.random() * nbSprites);
		
		setSprite(getSpriteName() + "_" + numSprite + ".png");		
	}
	
}
