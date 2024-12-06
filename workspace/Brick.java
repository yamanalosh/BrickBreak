/*
 * Author: Mr. M
 * Date: 12/02/24
 * Description: This component is the non-moving bricks which the user will need to eliminate by hitting them
 * with the ball. The bricks will be drawn in a static position and will have varying colors based on their remaining HP. (white - blue - red)
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;

public class Brick {
	private int width;
	private int height;
	private int x;
	private int y;
	private int hp;
	
	public Brick(int width, int height, int x, int y, int hp) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.hp = hp;
	}
	
	
	//getters and setters
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	//precondition: g is not null
	//postcondition: the brick is drawn using the color corresponding to its HP value.
	public void draw(Graphics g) {
		if(hp >=3)
		   g.setColor(Color.white);
		else if(hp>=2)
			g.setColor(Color.blue);
		else if(hp>=1)
			g.setColor(Color.red);
           g.fillRect(x, y, width, height);
		
		   
	}
	
	
	//precondition: none
	//postcondition: hp is reduced by one.
	public void hit() {
		hp--;
	}
	
	
	
}
