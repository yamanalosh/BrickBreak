/*
 * Author: Mr. M
 * Date: 12/02/24
 * Description: This is the driver program for the BrickBreak game featuring a classic arcade feel.
 * This project requires the Ball.java, Paddle.java and Brick.java files to operate. Although Brick 
 * is complete the other two are still in production. 
 */

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class BrickBreak extends JPanel implements KeyListener, ActionListener {

	private boolean play = false;
	private int score = 0;

	private int totalBricks;

	private Timer timer;
	private int delay = 8;

	private Brick[][] map;
	private int mapWidth;
	private int mapHeight;
	private int xGap;
	private int yGap;

	private Paddle player;
	private Ball ball;

	public BrickBreak(int width, int height, int xGap, int yGap) {
		this.xGap = xGap;
		this.yGap = yGap;
		mapWidth = width;
		mapHeight = height;
		totalBricks = mapWidth * mapHeight;
		player = new Paddle(310, 20, 100, 550);
		ball = new Ball(350, 450, 20);

		map = new Brick[mapHeight][mapWidth];
		setFocusable(true);
        addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				map[i][j] = new Brick(540 / mapWidth, 300 / mapHeight, j * (540 + xGap) / mapWidth + 80,
						i * (300 + yGap) / mapHeight + 50, 3);
			}
		}
		timer.start();
	}

	
	//precondition: Graphics g is not null.
	//postcondition: paints the entire game of brick break including all associated components onto the screen.
	//additionally will check to see if the game is over and draw the game over screen if appropriate.
	public void paint(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);

		// drawing map
		for (Brick[] br : map) {
			for (Brick b : br) {
				if (b != null)
					b.draw(g);
			}
		}
		
		// score
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("" + score, 590, 30);

		// borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 590);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(682, 0 , 3, 590);
		

        // the paddle
		player.draw(g);
		
		//the ball
		ball.draw(g);

		checkCollision(g);
		
		//check for game over
		if (ball.getYpos() > 570) {
			play = false;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game Over, Score: "+score, 190, 300);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart ", 230, 350);
		}
		else if (totalBricks <= 0) {
			play = false;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("You Won, Score: "+score, 190, 300);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart ", 230, 350);
		}
		g.dispose();
	}

	//precondition: the game has been properly initialized
	//postcondition: detects collision between the ball and other surfaces and changes the ball's direction accordingly.
	private void checkCollision(Graphics g) {

		Rectangle ballHitBox = new Rectangle(ball.getXpos(), ball.getYpos(), ball.getSize(), ball.getSize());
		Rectangle playerHitBox = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		
		g.setColor(Color.magenta);
		g.drawRect(ballHitBox.x, ballHitBox.y, ballHitBox.width, ballHitBox.height);
		g.drawRect(playerHitBox.x, playerHitBox.y, playerHitBox.width, playerHitBox.height);
		// paddle collision
		if (ballHitBox.intersects(playerHitBox)) {
			ball.reverseY();
			if (player.getVelocity() > 0) {
				ball.setXVelocity(1);
			}
			if (player.getVelocity() < 0) {
				ball.setXVelocity(-1);
			}
		}

		// brick collision
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] != null) {
					Rectangle brickHitBox = new Rectangle(map[i][j].getX(), map[i][j].getY(), map[i][j].getWidth(),
							map[i][j].getHeight());
					if (ballHitBox.intersects(brickHitBox)) {
						map[i][j].hit();
						score++;
						if (ball.getXpos() + ball.getSize() <= map[i][j].getX()) {
							ball.setX(map[i][j].getX()-ball.getSize() -1);
							ball.reverseX();
						} else if(ball.getXpos() + 1 >= map[i][j].getX() + map[i][j].getWidth()) {
							ball.setX(map[i][j].getX()+map[i][j].getWidth() +1);
							ball.reverseX();
						}else {
							ball.reverseY();
						}

						if (map[i][j].getHp() <= 0) {
							map[i][j] = null;
							totalBricks --;
						}

						break;
					}
				}
			}
		}

		// wall collision
		if (ball.getXpos() < 0 || ball.getXpos()+ball.getSize() > 682) {
			ball.reverseX();
		}
		
		if (ball.getYpos() < 0) {
			ball.reverseY();
		}


	}

	
	//precondition: A timer is set up to run the game with a proper delay
	//postondition: The actions required to play the game are taken and the screen updated.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (play) {
			//checkCollision();
			ball.move();
			player.move();
		}
		revalidate();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	//precondition: all components of the game properly intialized
	//postondition: paddle moves according to keys pressed (left/right). If the user presses enter the game is restarted.
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			play = true;
			if (player.getVelocity() == 0)
				player.addVelocity(8);
			else {
				player.addVelocity(4);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			play = true;
			if (player.getVelocity() == 0)
				player.addVelocity(-8);
			else {
				player.addVelocity(-4);
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			play = false;
			ball.setX(350);
			ball.setY(450);
			ball.setXVelocity(1);
			ball.setYVelocity(-2);
			player.setX(310);
			player.setVelocity(0);
			score = 0;
			totalBricks = 21;
			for (int i = 0; i < mapHeight; i++) {
				for (int j = 0; j < mapWidth; j++) {
					map[i][j] = new Brick(540 / mapWidth, 300 / mapHeight, j * (540 + xGap) / mapWidth + 80,
							i * (300 + yGap) / mapHeight + 50, 3);
				}
			}
			repaint();

		}

	}


}