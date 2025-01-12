import java.awt.*;
// Class author: Yaman Alosh
// Date created: 1/12/2025
// Has features for a ball object in the brick break game, including both actions and specifications of the ball.
public class Ball {
	//your code here!
	
	//don't forget you need instance variables:
	private int radius;
	private Color ballColor;
	private int xPos;
	private int yPos;
	private int xVelocity;
	private int yVelocity;
	
	
	//constructor(s): 
	// Pre-condition: None
	// Post-condition:Makes a ball with three parameters.
	public Ball(int startingXPos, int startingYPos, int ballRadius){
		xPos = startingXPos;
		yPos = startingYPos;
		ballColor = Color.BLUE;
		radius = ballRadius;
		xVelocity=1;
		yVelocity=1;

	}
	// Pre-condition: none
	// Post-condition: Makes a ball without parameters.
	public Ball() {
		ballColor = Color.BLUE;
		radius = 3;
		xPos = 200;
		yPos = 200;

	}
	// Pre-condition: none
	// Post-condition: Gets the radius of the ball.
		
	public int getSize() {
		return radius;
	}
	// Pre-condition: none
	// Post-condition: Makes the ball move in the other direction horizonally by switching the x-velocity's sign.
	public void reverseX() {
		xVelocity = xVelocity*-1;
	}
	// Pre-condition: none
	// Post-condition: Makes the ball move in the other direction vertically by switching the y-velocity's sign.
	public void reverseY() {
		yVelocity = yVelocity*-1;
	}
	// Pre-condition: none
	// Post-condition: moves the ball by adding its x-velocity to its x-position and its y-velocity to its y-position.

	public void move(){
		
			xPos += xVelocity;
		
		
			yPos += yVelocity;
		
	}
	// Pre-condition: none
	// Post-condition: returns the ball's radius.

	public int getRadius() {
		return radius;
	}
	// Pre-condition: none
	// Post-condition: Returns the ball's color.
	public Color getColor() {
		return ballColor;
	}
	// Pre-condition: none
	// Post-condition: Returns the ball's x-velocity.
	public int getXVelocity() {
		return xVelocity;
	}
	// Pre-condition: none

	// Post-condition: Returns the ball's y-velocity.
	public int getYVelocity() {
		return yVelocity;
	}
	// Pre-condition: new x-vel must be an int
	// Post-condition: sets the x-velocity of the ball to a new velocity.
	public void setXVelocity(int x){
		xVelocity = x;
	}
	// Pre-condition: new y-velocity must be an int.
	// Post-condition: Sets the y-velocity of the ball to a new velocity.
	public void setYVelocity(int y){
		yVelocity = y;
	}
	
	// Pre-condition: none
	// Post-condition: Draws the ball using a graphics object
	public void draw(Graphics g){
		g.setColor(ballColor);
		g.fillOval(xPos, yPos, radius, radius);
	}
	// Pre-condition: new radius must be int
	// Post-condition: sets the ball's radius to a new radius
	public void setRadius(int newRadius) {
		radius = newRadius;
	}
	// Pre-condition: new color must be of type Color
	// Post-condition: Sets the ball's color to a new color.
	public void setColor(Color newColor) {
		ballColor = newColor;
	}
	// Pre-condition: new x-pos and new y-pos must both be ints.
	// Post-condition: sets the ball's position to a new x-pos and a new y-pos.
	public void setPos(int newX, int newY) {
		xPos = newX;
		yPos = newY;
	}
	// Pre-condition: new x-pos must be int
	// Post-condition: Sets the ball's x-position to a new x-pos.
	public void setX(int newX) {
		xPos = newX;
	}
	// Pre-condition: new y-pos must be an int
	// Post-condition: sets the ball's y-pos to a new y-pos
	public void setY(int newY) {
		yPos = newY;
	}
	// Pre-condition: none
	// Returns the ball's x-pos.
	public int getXpos() {
		return xPos;
	}
	// Pre-condition: none
	// Post-condition: the ball's y-pos.
	public int getYpos() {
		return yPos; 
	}
}
