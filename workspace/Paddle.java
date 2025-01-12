import java.awt.*;
// Date created: 1/12/2024
// Class author: Yaman Alosh
// Has features for a paddle object in the brick break game, including both actions and specifications of the paddle.

public class Paddle {


	//your code here!


	
	//don't forget you need instance variables:
	private int width;
	private int height;
	private Color paddleColor = Color.BLUE;
	private int xPos;
	private int yPos;
	private int velocity;

	
	//constructor(s):
	// Pre-condition: none
	// Post-condition: Makes a paddle object without parameters.
	public Paddle(){
		xPos = 50;
		yPos = 350;
		paddleColor = Color.BLUE;
		width = 8;
		height = 4;

	}
	// Pre-condition: all 4 parameters are ints.
	// Post-condition: Makes a paddle object with 4 parameters.
	public Paddle(int startingWidth, int startingHeight,
	int startingXPos, int startingYPos) {
		xPos = startingXPos;
		yPos = startingYPos;
		width = startingWidth;
		height = startingHeight;
		paddleColor = Color.BLUE;
	}
	// Pre-condition: new x-pos must be an int.
	// Post-condition: Sets the x-position of the paddle to a new x-pos.
	public void setX(int newX) {
		xPos = newX;
	}
	// Pre-condition: new y-pos must be an int.
	// Post-condition: Sets the y-position of the paddle to a new y-position.
	public void setY(int newY) {
		yPos = newY;
	}
	// Pre-condition: none
	// Post-condition: draws a paddle using a graphics object.
public void draw(Graphics g){
	g.setColor(paddleColor);
	g.fillRect(xPos, yPos, width, height);
}
// Pre-condition: xPos + velocity must be more than or equal to zero and less than or equal to 400.
// Post-condition: Moves the paddle by increasing its x-position by the velocity, but only if it doesn't go out of the screen.

	public void move(){
if ((xPos + velocity <= 400) && (xPos + velocity >= 0)){
		xPos += velocity;
	}
	else
	 velocity =0;
	}
	// Pre-condition: Velocity increase must be an int.
	// Post-condition: Increases the velocity by a certain number.
	public void addVelocity(int vel) {
		velocity += vel;
	}
	// Pre-condition: New velocity must be an int.
	// Post-condition: sets the velocity to a new velocity.
	public void setVelocity(int vel) {
		velocity = vel;
	}
	// Pre-condition: none
	// Post-condition: returns the paddle width.
	public int getWidth() {
		return width;
	}
	// Pre-condition: None
	// Post-condition: Returns the paddle's height.
	public int getHeight() {
		return height;
	}
	// Pre-condition: none
	// Post-condition: Returns the paddle's color.
	public Color getColor() {
		return paddleColor;
	}
	// Pre-condition: new width must be an int.
	// Post-condition: the paddle's width to a new width.
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	// Pre-condition: new x-pos and new y-pos have to be ints.
	// Post-condition: sets the paddle's position to a new x-pos and a new y-pos.

	public void setPos(int newX, int newY) {
		xPos = newX;
		yPos = newY;
	}
	// Pre-condition: none
	// Post-condition: returns the paddle's velocity.
	public int getVelocity() {
		return velocity;
	}
	// Pre-condition: none
	// Post-condition: returns the paddle's x-pos.
	public int getX() {
		return xPos;
	}
	// Pre-condition: none
	// Post-condition: Returns the paddle's y-pos.
	public int getY() {
		return yPos; 
	}
	
	
}
